package com.shopping.promo;

import java.text.DecimalFormat;

import org.junit.Assert;

import com.shopping.cart.Item;
import com.shopping.cart.ShoppingCart;
import com.shopping.dao.product.MockProductDao;
import com.shopping.dao.product.ProductDao;

import junit.framework.TestCase;

public class DiscountPromoTest extends TestCase {
	private ShoppingCart cart = new ShoppingCart();
	private static final double DISCOUNT_RATE = 0.10;
	private DiscountPromo promo = new DiscountPromo(DISCOUNT_RATE);
	private Item item;

	@Override
	protected void setUp() throws Exception {
		ProductDao dao = new MockProductDao();
		item = new Item(dao.getProduct("ult_large"), 1);
		cart.add(item);
		cart.setTotal(item.getProduct().getPrice() * item.getQty());
	}

	public void testApplyPromo() {
		promo.applyPromo(cart);
		double cartTotal = item.getProduct().getPrice() * item.getQty();
		double expectedTotal = cartTotal - (cartTotal * DISCOUNT_RATE);
		DecimalFormat f = new DecimalFormat("##.00");
		Assert.assertEquals(f.format(expectedTotal), f.format(cart.getTotal()));
	}
}
