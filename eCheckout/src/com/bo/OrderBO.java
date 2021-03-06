package com.bo;

import java.sql.Date;

public class OrderBO{

	String orderNo;
	String customerId;
	String productId;
	int quantity;
	Date date;
	int orderStatus;
	double price;
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderNo == null) ? 0 : orderNo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderBO other = (OrderBO) obj;
		if (orderNo == null) {
			if (other.orderNo != null)
				return false;
		} else if (!orderNo.equals(other.orderNo))
			return false;
		return true;
	}
	public OrderBO(String orderNo, String customerId, String productId, int quantity, Date date, int orderStatus,
			double price) {
		super();
		this.orderNo = orderNo;
		this.customerId = customerId;
		this.productId = productId;
		this.quantity = quantity;
		this.date = date;
		this.orderStatus = orderStatus;
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderBO [orderNo=" + orderNo + ", customerId=" + customerId + ", productId=" + productId + ", quantity="
				+ quantity + ", date=" + date + ", orderStatus=" + orderStatus + ", price=" + price + "]";
	}
	public OrderBO() {
		super();
	}
	

}