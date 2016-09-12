package com.shopping.dao.promo;

import java.util.HashMap;
import java.util.Map;

import com.shopping.promo.AddFreeItemPromo;
import com.shopping.promo.BulkDiscountPromo;
import com.shopping.promo.DiscountPromo;
import com.shopping.promo.MultipleSalePromo;
import com.shopping.promo.Promo;

public class MockPromoDao implements PromoDao {
	private static Map<String, Promo> promoByProductCode = new HashMap<>();
	private static Map<String, Promo> promoByPromoCode = new HashMap<>();

	static {
		promoByProductCode.put("ult_small", new MultipleSalePromo("ult_small", 2, 3));
		promoByProductCode.put("ult_medium", new AddFreeItemPromo("ult_medium", "1gb", 1));
		promoByProductCode.put("ult_large", new BulkDiscountPromo("ult_large", 4, 5 / 44.90));

		promoByPromoCode.put("I<3AMAYSIM", new DiscountPromo(0.1));

	}

	@Override
	public Promo getPromoByProduct(String productCode) {
		return promoByProductCode.get(productCode);
	}

	@Override
	public Promo getPromo(String promoCode) {
		return promoByPromoCode.get(promoCode);
	}

}
