/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.nagacc.facades.populators;

import org.nagacc.core.model.SellerModel;
import org.nagacc.facades.product.data.SellerData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

/**
 * Populates {@link SellerData} with genders
 */
public class NagAccSellerDataPopulator implements Populator<SellerModel, SellerData>
{

	@Override
	public void populate(final SellerModel source, final SellerData target) throws ConversionException
	{
		target.setCode(source.getCode());
		target.setName(source.getName());
}
}
