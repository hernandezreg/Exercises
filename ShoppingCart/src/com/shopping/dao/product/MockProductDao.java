package com.shopping.dao.product;

import java.util.HashMap;
import java.util.Map;

import com.shopping.product.Product;

public class MockProductDao implements ProductDao {
	private static Map<String, Product> productByCode = new HashMap<>();

	static {
		productByCode.put("ult_small", new Product("ult_small", "Unlimited 1GB", 24.90));
		productByCode.put("ult_medium", new Product("ult_medium", "Unlimited 2GB", 29.90));
		productByCode.put("ult_large", new Product("ult_large", "Unlimited 5GB", 44.90));
		productByCode.put("1gb", new Product("1gb", "1 GB Data-pack", 9.90));
	}

	@Override
	public Product getProduct(String productCode) {
		Product storedProduct = productByCode.get(productCode);
		return new Product(storedProduct.getProductCode(), storedProduct.getProductName(), storedProduct.getPrice());
	}

}
