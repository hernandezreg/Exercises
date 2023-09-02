package com.shopping.cart;

import java.text.DecimalFormat;

import org.junit.Assert;

import com.shopping.dao.product.MockProductDao;
import com.shopping.dao.product.ProductDao;

import junit.framework.TestCase;

public class ShoppingCartTest extends TestCase {

	private ProductDao productDao = new MockProductDao();
	DecimalFormat f = new DecimalFormat("##.00");
//add comment
//added new comment
//added new ocmment
//added new comment
	public void testCart1() {
		Cart cart = new ShoppingCart();
		cart.add(new Item(productDao.getProduct("ult_small"), 3));
		cart.add(new Item(productDao.getProduct("ult_large"), 1));
		cart.computeTotal();
		Assert.assertEquals(f.format(cart.getTotal()), f.format(94.70));
	}

	public void testCart2() {
		Cart cart = new ShoppingCart();
		cart.add(new Item(productDao.getProduct("ult_small"), 2));
		cart.add(new Item(productDao.getProduct("ult_large"), 4));
		cart.computeTotal();
		Assert.assertEquals(f.format(cart.getTotal()), f.format(209.40));
	}

	public void testCart3() {
		Cart cart = new ShoppingCart();
		String promoProductCode = "ult_medium";
		String addedProdCode = "1gb";
		cart.add(new Item(productDao.getProduct("ult_small"), 1));
		cart.add(new Item(productDao.getProduct(promoProductCode), 2));
		cart.computeTotal();
		Assert.assertEquals(f.format(cart.getTotal()), f.format(84.70));
		// 3 items coz of the added item
		Assert.assertEquals(3, cart.getItems().size());
		// free item 1 is to 1 ratio to promo product
		ShoppingCart shoppingCart = (ShoppingCart) cart;
		Assert.assertEquals(shoppingCart.getItem(promoProductCode).getQty(),
				shoppingCart.getItem(addedProdCode).getQty());
	}

	public void testCart4() {
		Cart cart = new ShoppingCart();
		cart.add(new Item(productDao.getProduct("ult_small"), 1));
		cart.add(new Item(productDao.getProduct("1gb"), 1), "I<3AMAYSIM");
		cart.computeTotal();
		Assert.assertEquals(f.format(cart.getTotal()), f.format(31.32));
	}

}
