package com.shopping.promo;

import com.shopping.cart.Cart;
import com.shopping.cart.Item;
import com.shopping.cart.ShoppingCart;
import com.shopping.dao.product.MockProductDao;
import com.shopping.dao.product.ProductDao;

public class AddFreeItemPromo implements Promo {
	private String productCode;
	private String addProductCode;
	private double addRatio;
	private ProductDao dao = new MockProductDao();

	public AddFreeItemPromo(String productCode, String addProductCode, double addRatio) {
		this.productCode = productCode;
		this.addProductCode = addProductCode;
		this.addRatio = addRatio;
	}

	@Override
	public void applyPromo(Cart cart) {
		ShoppingCart shoppingCart = (ShoppingCart) cart;
		Item item = shoppingCart.getItem(productCode);
		Double qtyDouble = item.getQty() * addRatio;
		if (qtyDouble.intValue() > 0) {
			Item addedItem = new Item(dao.getProduct(addProductCode), qtyDouble.intValue());
			// make the item free
			addedItem.getProduct().setPrice(0);
			shoppingCart.add(addedItem);
		}
	}

}
