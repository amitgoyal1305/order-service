package com.order.entity;

public class OrderItem {

	private String productCode;
	private String productName;
	private int quantity;

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItems [productCode=" + productCode + ", productName=" + productName + ", quantity=" + quantity
				+ "]";
	}

}
