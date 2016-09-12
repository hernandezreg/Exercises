package com.shopping.cart;

import com.shopping.product.Product;

public class Item {
	private Product product;
	private int qty;

	public Item(Product product, int qty) {
		super();
		this.product = product;
		this.qty = qty;
	}

	public Product getProduct() {
		return product;
	}

	public int getQty() {
		return qty;
	}

}
