package org.nagacc.core.job;

import de.hybris.platform.cms2.model.site.CMSSiteModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.model.ModelService;
import org.apache.commons.collections.CollectionUtils;
import org.nagacc.core.dao.NagAccOrderDao;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class NagAccTodayDispatchOrderToSiteJobPerformable extends AbstractJobPerformable<CronJobModel> {

    private ModelService modelService;

    private NagAccOrderDao nagAccOrderDao;

    @Override
    public PerformResult perform(CronJobModel cronJobModel) {
        try {
            LocalDate localDate = LocalDate.now();
            final Date currentDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

            List<CMSSiteModel> sites = nagAccOrderDao.fetchActiveSites();

            if (CollectionUtils.isNotEmpty(sites)) {
                for (CMSSiteModel site : sites) {
                    List<AbstractOrderModel> orders = nagAccOrderDao.fetchOrdersWithDispatchDate(currentDate, site);
                    site.setTodaysDispatchOrdersCount(orders.size());
                    site.setTodaysDispatchOrders(orders);
                    modelService.save(site);
                }
            }
            return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
        } catch (Exception e) {
            return new PerformResult(CronJobResult.FAILURE, CronJobStatus.ABORTED);
        }
    }

    @Override
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    public void setNagAccOrderDao(NagAccOrderDao nagAccOrderDao) {
        this.nagAccOrderDao = nagAccOrderDao;
    }
}
