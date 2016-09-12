package com.shopping.product;

public class Product implements Cloneable {
	private String productCode;
	private String productName;
	private double price;
	
	public Product(String productCode, String productName, double price) {
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
	}
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
