package com.shopping.dao.promo;

import com.shopping.promo.Promo;

public interface PromoDao {
	public Promo getPromoByProduct(String productCode);
	public Promo getPromo(String promoCode);
}
