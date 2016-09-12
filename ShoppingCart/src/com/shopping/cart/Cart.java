package com.shopping.cart;

import java.util.List;

public interface Cart {
	public void computeTotal();

	public void add(Item item);

	public void add(Item item, String promocode);

	public List<Item> getItems();

	public double getTotal();
}
