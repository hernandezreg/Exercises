package com.shopping.promo;

import com.shopping.cart.Cart;
import com.shopping.cart.Item;
import com.shopping.cart.ShoppingCart;

public class MultipleSalePromo implements Promo {
	private String productCode;
	private int multiplier;
	private int divisor;

	public MultipleSalePromo(String productCode, int multiple, int divisor) {
		this.multiplier = multiple;
		this.divisor = divisor;
		this.productCode = productCode;
	}

	@Override
	public void applyPromo(Cart cart) {
		ShoppingCart shoppingCart = (ShoppingCart) cart;
		Item item = shoppingCart.getItem(productCode);
		if (item.getQty() >= divisor) {
			double itemTotal = item.getProduct().getPrice() * item.getQty();
			// subtract the orig item total
			double cartTotal = shoppingCart.getTotal() - itemTotal;
			double promoQty = (item.getQty() / divisor) * multiplier;
			double promoExcess = item.getQty() % divisor;
			itemTotal = (promoQty * item.getProduct().getPrice()) + (promoExcess * item.getProduct().getPrice());
			shoppingCart.setTotal(cartTotal + itemTotal);
		}
	}

}
