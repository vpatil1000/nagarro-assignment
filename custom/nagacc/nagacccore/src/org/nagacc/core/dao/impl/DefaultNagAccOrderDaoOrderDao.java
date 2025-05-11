package org.nagacc.core.dao.impl;

import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.order.daos.impl.DefaultOrderDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.cms2.model.site.CMSSiteModel;
import org.nagacc.core.dao.NagAccOrderDao;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

public class DefaultNagAccOrderDaoOrderDao extends DefaultOrderDao implements NagAccOrderDao {

    @Resource
    private FlexibleSearchService flexibleSearchService;

    @Override
    public List<AbstractOrderModel> fetchOrdersWithDispatchDate(final Date dispatchDate, final CMSSiteModel site) {
        final StringBuilder sql = new StringBuilder("SELECT {o.pk} FROM {Order AS o} WHERE {o.site} = ?site AND {o.dispatchDate} = ?dispatchDate");
        final FlexibleSearchQuery query = new FlexibleSearchQuery(sql.toString());
        query.addQueryParameter("dispatchDate", dispatchDate);
        query.addQueryParameter("site", site);

        final SearchResult<AbstractOrderModel> result = flexibleSearchService.search(query);
        return result.getResult();
    }

    @Override
    public List<CMSSiteModel> fetchActiveSites() {
        final StringBuilder sql = new StringBuilder("SELECT {site.pk} FROM {CMSSite AS site} WHERE {site.active} = 1");
        final FlexibleSearchQuery query = new FlexibleSearchQuery(sql.toString());
        final SearchResult<CMSSiteModel> result = flexibleSearchService.search(query);
        return result.getResult();
    }
}
