/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.nagacc.fulfilmentprocess.actions.order;

import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.orderprocessing.model.OrderProcessModel;
import de.hybris.platform.processengine.action.AbstractSimpleDecisionAction;
import de.hybris.platform.servicelayer.model.ModelService;
import org.apache.commons.collections4.CollectionUtils;
import org.joda.time.LocalDate;

import javax.annotation.Resource;
import java.util.List;

public class AssignDispatchDateToOrderAction extends AbstractSimpleDecisionAction<OrderProcessModel> {

	@Resource
	private ModelService modelService;

	@Override
	public Transition executeAction(OrderProcessModel orderProcessModel) throws Exception {
		final OrderModel orderModel = orderProcessModel.getOrder();
		final List<AbstractOrderEntryModel> sellerEntries = orderModel.getEntries().stream()
				.filter(e -> e.getSeller() != null)
				.toList();
		int maxLeadTime = 1;
		if (CollectionUtils.isNotEmpty(sellerEntries)) {
			 maxLeadTime = sellerEntries.stream()
					.mapToInt(e -> e.getSeller().getLeadTime())
					.max()
					.orElse(1);
		}
		orderModel.setDispatchDate(LocalDate.now().plusDays(maxLeadTime).toDate());
		modelService.save(orderModel);
		return Transition.OK;
	}

}

