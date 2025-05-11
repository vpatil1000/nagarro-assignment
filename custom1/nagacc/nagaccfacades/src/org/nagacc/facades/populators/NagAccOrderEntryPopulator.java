package org.nagacc.facades.populators;

import org.nagacc.core.model.SellerModel;
import org.nagacc.facades.product.data.SellerData;
import de.hybris.platform.commercefacades.order.data.OrderEntryData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;

public class NagAccOrderEntryPopulator implements Populator<AbstractOrderEntryModel, OrderEntryData> {
    private Converter<SellerModel, SellerData> sellerConverter;
    @Override
    public void populate(AbstractOrderEntryModel abstractOrderEntryModel, OrderEntryData orderEntryData)
            throws ConversionException {
          if(null!= abstractOrderEntryModel.getSeller()){
              orderEntryData.setSeller(sellerConverter.convert(abstractOrderEntryModel.getSeller()));
          }
    }

    public void setSellerConverter(
            Converter<SellerModel, SellerData> sellerConverter) {
        this.sellerConverter = sellerConverter;
    }
}
