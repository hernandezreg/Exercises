package com.shopping.promo;

import org.junit.Assert;

import com.shopping.cart.Item;
import com.shopping.cart.ShoppingCart;
import com.shopping.dao.product.MockProductDao;
import com.shopping.dao.product.ProductDao;

import junit.framework.TestCase;

public class AddFreeItemPromoTest extends TestCase {
	private ShoppingCart cart = new ShoppingCart();
	private static final String ADDED_PRODUCT_CODE = "1gb";
	// add 1 for every 3
	private AddFreeItemPromo promo = new AddFreeItemPromo("ult_medium", ADDED_PRODUCT_CODE, 0.34);

	//added comment
	@Override
	protected void setUp() throws Exception {
		ProductDao dao = new MockProductDao();
		cart.add(new Item(dao.getProduct("ult_medium"), 6));
	}

	public void testApplyPromo() {
		promo.applyPromo(cart);
		Assert.assertEquals(2, cart.getItems().size());
		Assert.assertEquals(2, cart.getItem(ADDED_PRODUCT_CODE).getQty());
	}

}
