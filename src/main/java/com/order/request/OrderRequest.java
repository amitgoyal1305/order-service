package com.order.request;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.order.entity.OrderItem;

public class OrderRequest {

	@Size(min = 2,message = "Name should have altleat two charector")
	private String customerName;
	
	private Date orderDate = new Date();

	@Size(min  = 2,message = "Shipping address should have altleat two charector")
	private String shippingAddress;

	@NotEmpty( message = "Item Id Should have altleat one Item Id")
	private List<OrderItem>      orderItems;
	
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

	/*
	 * public List<Integer> getItemIds() { return itemIds; }
	 * 
	 * public void setItemIds(List<Integer> itemIds) { this.itemIds = itemIds; }
	 */
	
	
	public Integer getQuantity() {
		return quantity;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
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
				+ shippingAddress +  ", quantity=" + quantity + ", price=" + price + "]";
	}

	
}
