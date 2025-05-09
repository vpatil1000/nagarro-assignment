/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.nagacc.core.value.provider;

import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.provider.impl.AbstractFacetValueDisplayNameProvider;
import de.hybris.platform.solrfacetsearch.search.SearchQuery;
import org.apache.commons.lang3.StringUtils;

public class NagAccSellerFacetDisplayNameProvider extends AbstractFacetValueDisplayNameProvider {

		@Override
		public String getDisplayName(final SearchQuery query, final IndexedProperty property, final String facetValue)
		{
			if (StringUtils.isNotBlank(facetValue))
			{
				return facetValue;
			}
			return StringUtils.EMPTY;
		}

	}