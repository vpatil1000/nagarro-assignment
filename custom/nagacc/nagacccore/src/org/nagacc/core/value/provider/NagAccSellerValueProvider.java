/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.nagacc.core.value.provider;

import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.solrfacetsearch.config.IndexConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.exceptions.FieldValueProviderException;
import de.hybris.platform.solrfacetsearch.provider.FieldNameProvider;
import de.hybris.platform.solrfacetsearch.provider.FieldValue;
import de.hybris.platform.solrfacetsearch.provider.FieldValueProvider;
import de.hybris.platform.solrfacetsearch.provider.impl.AbstractPropertyFieldValueProvider;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.nagacc.core.model.SellerModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NagAccSellerValueProvider extends AbstractPropertyFieldValueProvider implements FieldValueProvider {

    private static final Logger LOG = Logger.getLogger(NagAccSellerValueProvider.class);
    private FieldNameProvider fieldNameProvider;

    @Override
    public Collection<FieldValue> getFieldValues(final IndexConfig indexConfig, final IndexedProperty indexedProperty,
                                                 final Object model) throws FieldValueProviderException {
        if (model instanceof ProductModel productModel) {
            return createFieldValue(productModel, indexedProperty);
        } else {
            throw new FieldValueProviderException("Error occurred in SellerValueProvider!!");
        }

    }

    protected List<FieldValue> createFieldValue(final ProductModel productModel, final IndexedProperty indexedProperty) {
        final List<FieldValue> fieldValues = new ArrayList<>();
        final List<SellerModel> sellerModelList = (List<SellerModel>) productModel.getSeller();
        if (CollectionUtils.isNotEmpty(sellerModelList)) {
            for (final SellerModel sellerModel : sellerModelList) {
                if (StringUtils.isNotBlank(sellerModel.getName())) {
                    addFieldValues(fieldValues, indexedProperty, null, sellerModel.getName());
                }
            }
        } else {
            LOG.info("Seller is Empty for Product :: " + productModel.getCode());
        }
        return fieldValues;
    }

    protected void addFieldValues(final List<FieldValue> fieldValues, final IndexedProperty indexedProperty,
                                  final LanguageModel language, final Object value) {
        final Collection<String> fieldNames = getFieldNameProvider().getFieldNames(indexedProperty,
                (language == null) ? null : language.getIsocode());
        for (final String fieldName : fieldNames) {
            fieldValues.add(new FieldValue(fieldName, value));
        }
    }

    public FieldNameProvider getFieldNameProvider() {
        return fieldNameProvider;
    }

    public void setFieldNameProvider(FieldNameProvider fieldNameProvider) {
        this.fieldNameProvider = fieldNameProvider;
    }
}