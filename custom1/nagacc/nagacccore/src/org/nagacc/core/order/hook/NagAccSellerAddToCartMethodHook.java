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

                // Check if the product is already in the cart by checking the existing cart entries
                if (isProductInCartAndHasSeller(product)) {
                    LOG.info("Product {} is already in the cart. Seller will not be reassigned.", product.getCode());
                } else {
                    // If it's the first time, assign a seller
                    assignSellerToProduct(entry);
                }
            }
        }

    private boolean isProductInCartAndHasSeller(ProductModel product) {
        CartModel cart = cartService.getSessionCart();
        for (AbstractOrderEntryModel entry : cart.getEntries()) {
            if (entry.getProduct().equals(product) && entry.getSeller()!= null) {
                return true; // Product already in the cart
            }
        }
        return false; // Product is not in the cart
    }

    private void assignSellerToProduct(AbstractOrderEntryModel entry) {
        final List<SellerModel> sellers = entry.getProduct().getSeller().stream().collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(sellers)) {
            entry.setSeller(sellers.get(0)); // You can change logic here to choose the seller based on criteria
            modelService.save(entry); // Save the updated cart entry
            LOG.info("Assigned seller {} to product {}", entry.getSeller().getName(), entry.getProduct().getCode());
        } else {
            LOG.warn("No sellers found for product {}", entry.getProduct().getCode());
        }
    }
}
