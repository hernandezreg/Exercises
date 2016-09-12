package com.shopping.cart;

import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.promo.MockPromoDao;
import com.shopping.dao.promo.PromoDao;
import com.shopping.promo.Promo;

public class ShoppingCart implements Cart {
	private List<Item> items = new ArrayList<>();
	private List<String> cartPromoCodes = new ArrayList<>();
	private double total;
	private PromoDao promoDao = new MockPromoDao();

	@Override
	public void add(Item item) {
		getItems().add(item);
	}

	@Override
	public void add(Item item, String cartPromoCode) {
		add(item);
		this.cartPromoCodes.add(cartPromoCode);
	}

	@Override
	public void computeTotal() {
		for (int ctr = 0; ctr < items.size(); ctr++) {
			Item eachItem = items.get(ctr);
			total += eachItem.getProduct().getPrice() * eachItem.getQty();
			Promo productPromo = promoDao.getPromoByProduct(eachItem.getProduct().getProductCode());
			if (productPromo != null) {
				productPromo.applyPromo(this);
			}
		}
		for (String eachPromoCode : this.cartPromoCodes) {
			Promo cartPromo = promoDao.getPromo(eachPromoCode);
			if (cartPromo != null) {
				cartPromo.applyPromo(this);
			}
		}
	}

	public List<Item> getItems() {
		return this.items;
	}

	public Item getItem(String productCode) {
		for (Item each : items) {
			if (each.getProduct().getProductCode().equals(productCode)) {
				return each;
			}
		}
		return null;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
