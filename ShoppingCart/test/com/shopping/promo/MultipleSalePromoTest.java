package com.shopping.promo;

import java.text.DecimalFormat;

import org.junit.Assert;

import com.shopping.cart.Item;
import com.shopping.cart.ShoppingCart;
import com.shopping.dao.product.MockProductDao;
import com.shopping.dao.product.ProductDao;

import junit.framework.TestCase;

public class MultipleSalePromoTest extends TestCase {

	private ShoppingCart cart = new ShoppingCart();
	// 3 at the price of 1
	private MultipleSalePromo promo = new MultipleSalePromo("ult_large", 1, 3);
	private Item item;

	@Override
	protected void setUp() throws Exception {
		ProductDao dao = new MockProductDao();
		item = new Item(dao.getProduct("ult_large"), 4);
		cart.add(item);
		cart.setTotal(item.getProduct().getPrice() * item.getQty());
	}

	public void testApplyPromo() {
		promo.applyPromo(cart);
		double expectedTotal = item.getProduct().getPrice() * 2;
		DecimalFormat f = new DecimalFormat("##.00");
		Assert.assertEquals(f.format(expectedTotal), f.format(cart.getTotal()));
	}

}
