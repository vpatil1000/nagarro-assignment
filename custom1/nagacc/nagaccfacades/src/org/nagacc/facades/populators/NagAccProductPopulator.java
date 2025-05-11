/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.nagacc.facades.populators;

import org.nagacc.core.model.SellerModel;
import org.nagacc.facades.product.data.SellerData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.List;
/**
 * Populates {@link ProductData} with genders
 */
public class NagAccProductPopulator implements Populator<ProductModel, ProductData>
{
	private Converter<SellerModel, SellerData> sellerConverter;

	protected Converter<SellerModel, SellerData> getSellerConverter()
	{
		return sellerConverter;
	}

	@Required
	public void setSellerConverter(final Converter<SellerModel, SellerData> sellerConverter)
	{
		this.sellerConverter = sellerConverter;
	}

	@Override
	public void populate(final ProductModel source, final ProductData target) throws ConversionException
	{

			if (CollectionUtils.isNotEmpty(source.getSeller()))
			{
				final List<SellerData> sellers = new ArrayList<SellerData>();
				for (final SellerModel seller : source.getSeller())
				{
					sellers.add(getSellerConverter().convert(seller));
				}
				target.setSellers(sellers);
			}

}
}
