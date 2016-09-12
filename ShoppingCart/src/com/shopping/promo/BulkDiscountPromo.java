package com.shopping.promo;

import com.shopping.cart.Cart;
import com.shopping.cart.Item;
import com.shopping.cart.ShoppingCart;

public class BulkDiscountPromo extends DiscountPromo {
	private String productCode;
	private int minQty;

	public BulkDiscountPromo(String productCode, int minQty, double discount) {
		super(discount);
		this.minQty = minQty;
		this.productCode = productCode;
	}

	@Override
	public void applyPromo(Cart cart) {
		ShoppingCart shoppingCart = (ShoppingCart) cart;
		Item item = shoppingCart.getItem(productCode);
		if (item.getQty() >= minQty) {
			double itemTotal = item.getProduct().getPrice() * item.getQty();
			// subtract the orig item total
			double cartTotal = shoppingCart.getTotal() - itemTotal;
			shoppingCart.setTotal(cartTotal + (itemTotal - (itemTotal * discount)));
		}
	}

}
