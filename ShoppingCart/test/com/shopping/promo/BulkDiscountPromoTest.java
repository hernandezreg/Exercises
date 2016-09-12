package com.shopping.promo;

import java.text.DecimalFormat;

import org.junit.Assert;

import com.shopping.cart.Item;
import com.shopping.cart.ShoppingCart;
import com.shopping.dao.product.MockProductDao;
import com.shopping.dao.product.ProductDao;

import junit.framework.TestCase;

public class BulkDiscountPromoTest extends TestCase {
	private ShoppingCart cart = new ShoppingCart();
	private BulkDiscountPromo promo = new BulkDiscountPromo("ult_large", 2, 5 / 44.90);

	@Override
	protected void setUp() throws Exception {
		ProductDao dao = new MockProductDao();
		Item item = new Item(dao.getProduct("ult_large"), 6);
		cart.add(item);
		cart.setTotal(item.getProduct().getPrice() * item.getQty());
	}

	public void testApplyPromo() {
		promo.applyPromo(cart);
		double expectedTotal = (44.90 * 6) - (5 * 6);
		DecimalFormat f = new DecimalFormat("##.00");
		Assert.assertEquals(f.format(cart.getTotal()), f.format(expectedTotal));
	}
}
