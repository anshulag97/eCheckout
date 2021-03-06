package com.bo;

import java.io.InputStream;

public class ProductBO{

	private String productId;
	private String productName;
	private String material;
	private String collection;
	private double length;
	private double width;
	private String colour;
	private String description;
	private InputStream image;
	private double price;
		

	public InputStream getImage() {
		return image;
	}
	public void setImage(InputStream image) {
		this.image = image;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getCollection() {
		return collection;
	}
	public void setCollection(String collection) {
		this.collection = collection;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public ProductBO(String productId, String productName, String material, String collection, double length,
			double width, String colour, String description, double price, InputStream image) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.material = material;
		this.collection = collection;
		this.length = length;
		this.width = width;
		this.colour = colour;
		this.description = description;
		this.price = price;
		this.image = image;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
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
		ProductBO other = (ProductBO) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ProductBO [productId=" + productId + ", productName=" + productName + ", material=" + material
				+ ", collection=" + collection + ", length=" + length + ", width=" + width + ", colour=" + colour
				+ ", description=" + description + ",price=" + price + "]";
	}
// image=" + image + ", 
	
}
