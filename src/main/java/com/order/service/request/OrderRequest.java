package com.order.service.request;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class OrderRequest {

	@Size(min = 2,message = "Name should have altleat two charector")
	private String customerName;
	
	private Date orderDate = new Date();

	@Size(min  = 2,message = "Shipping address should have altleat two charector")
	private String shippingAddress;

	@Min(value = 1 , message = "Item Id Should have altleat one Number Value Not Zero")
	private Integer itemId;
	
	@Min(value = 1 , message = "quantity Should have altleat one Number Value Not Zero")
	private Integer quantity;
	
	@Min(value = 1 , message = "price Should have altleat one Number Not Zero")
	private Integer price;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderRequest [customerName=" + customerName + ", orderDate=" + orderDate + ", shippingAddress="
				+ shippingAddress + ", itemId=" + itemId + ", quantity=" + quantity + ", price=" + price + "]";
	}

	
}
