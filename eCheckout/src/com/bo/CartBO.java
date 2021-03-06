	package com.bo;

public class CartBO {

	String customerId;
	String productId;
	int quantity;
	double price;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public CartBO(String customerId, String productId, int quantity, double price) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}
	public CartBO() {
		super();
	}
	@Override
	public String toString() {
		return "CartBO [customerId=" + customerId + ", productId=" + productId + ", quantity=" + quantity + ", price="
				+ price + "]";
	}
	
}
