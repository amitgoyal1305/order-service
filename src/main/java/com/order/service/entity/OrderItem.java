package com.order.service.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "OrderItem")
public class OrderItem {
	
	@Id
	private int id;
	private String productCode;
	private String productName;
	private int quantity;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderItems [id=" + id + ", productCode=" + productCode + ", productName=" + productName + ", quantity="
				+ quantity + "]";
	}

}
