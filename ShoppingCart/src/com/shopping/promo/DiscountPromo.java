package com.shopping.promo;

import com.shopping.cart.Cart;
import com.shopping.cart.ShoppingCart;

public class DiscountPromo implements Promo {
	protected double discount;

	public DiscountPromo(double discount) {
		this.discount = discount;
	}

	@Override
	public void applyPromo(Cart cart) {
		ShoppingCart shoppingCart = (ShoppingCart) cart;
		double cartTotal = shoppingCart.getTotal();
		shoppingCart.setTotal(cartTotal - (cartTotal * discount));
	}

}
