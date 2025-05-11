package org.nagacc.core.dao;

import de.hybris.platform.cms2.model.site.CMSSiteModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;

import java.util.Date;
import java.util.List;

public interface NagAccOrderDao {

    List<AbstractOrderModel> fetchOrdersWithDispatchDate(final Date dispatchDate, final CMSSiteModel site);

    List<CMSSiteModel> fetchActiveSites();

}
