package org.nagacc.core.job;

import de.hybris.platform.cms2.model.site.CMSSiteModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class NagAccTodayDispatchOrderToSiteJobPerformable extends AbstractJobPerformable<CronJobModel> {

    private static final Logger LOG = Logger.getLogger(NagAccTodayDispatchOrderToSiteJobPerformable.class);

    private ModelService modelService;

    @Override
    public PerformResult perform(CronJobModel cronJobModel) {
        try {
            LocalDate localDate = LocalDate.now();
            final Date currentDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

            // 1. Fetch all active sites
            String siteQuery = "SELECT {site.pk} FROM {CMSSite AS site} WHERE {site.active} = 1";
            List<CMSSiteModel> sites = flexibleSearchService.<CMSSiteModel>search(siteQuery).getResult();

            // 2. Loop through each site and fetch orders for that site with today's dispatch date
            for (CMSSiteModel site : sites) {

                final StringBuilder sql = new StringBuilder("SELECT {o.code} FROM {Order AS o} WHERE {o.site} = ?site AND {o.dispatchDate} = ?dispatchDate");
                final FlexibleSearchQuery query = new FlexibleSearchQuery(sql.toString());
                query.addQueryParameter("dispatchDate", currentDate);
                query.addQueryParameter("site", site);

                final SearchResult<AbstractOrderModel> result = flexibleSearchService.search(query);
                List<AbstractOrderModel> orders = result.getResult();

                // 3. Calculate the order count for this site
                int orderCount = orders.size();

                // 4. Update the CMSite model with this order count
                site.setTodaysDispatchOrdersCount(orderCount);
                modelService.save(site);

                LOG.info("Dispatch order count for site" +  orderCount);

            }
            return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
        } catch (Exception e) {
            //LOG.error("Error while calculating dispatch order counts for multiple sites", e);
            return new PerformResult(CronJobResult.FAILURE, CronJobStatus.ABORTED);
        }
    }

    @Override
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }


}
