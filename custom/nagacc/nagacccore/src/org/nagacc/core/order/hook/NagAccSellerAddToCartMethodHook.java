package org.nagacc.core.order.hook;

import org.nagacc.core.model.SellerModel;
import de.hybris.platform.commerceservices.order.CommerceCartModification;
import de.hybris.platform.commerceservices.order.CommerceCartModificationException;
import de.hybris.platform.commerceservices.order.hook.CommerceAddToCartMethodHook;
import de.hybris.platform.commerceservices.service.data.CommerceCartParameter;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.order.CartService;
import de.hybris.platform.servicelayer.model.ModelService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

public class NagAccSellerAddToCartMethodHook implements CommerceAddToCartMethodHook {

    private static final Logger LOG = LoggerFactory.getLogger(NagAccSellerAddToCartMethodHook.class);

    @Resource(name = "modelService")
    private ModelService modelService;

    @Resource
    private CartService cartService;

    @Override
    public void beforeAddToCart(CommerceCartParameter parameters) throws CommerceCartModificationException {

    }

    @Override
    public void afterAddToCart(CommerceCartParameter parameters, CommerceCartModification result) {

        if (result.getQuantityAdded() > 0) {
            final AbstractOrderEntryModel entry = result.getEntry();
            final ProductModel product = entry.getProduct();

            if (isProductInCartAndHasSeller(product)) {
                LOG.info("Product {} is already in the cart. Seller will not be reassigned.", product.getCode());
            } else {
                assignSellerToProduct(entry);
            }
        }
    }

    private boolean isProductInCartAndHasSeller(ProductModel product) {
        CartModel cart = cartService.getSessionCart();
        for (AbstractOrderEntryModel entry : cart.getEntries()) {
            if (entry.getProduct().equals(product) && entry.getSeller() != null) {
                return true;
            }
        }
        return false;
    }

    private void assignSellerToProduct(AbstractOrderEntryModel entry) {
        final List<SellerModel> sellers = entry.getProduct().getSeller().stream().collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(sellers)) {
            entry.setSeller(sellers.get(0));
            modelService.save(entry);
            LOG.info("Assigned seller {} to product {}", entry.getSeller().getName(), entry.getProduct().getCode());
        } else {
            LOG.warn("No sellers found for product {}", entry.getProduct().getCode());
        }
    }
}
