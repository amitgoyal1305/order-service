package com.order.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order  {
	private Integer id;
	private String customerName;
	private Date orderDate;
	private String shippingAddress;
	private List<OrderItem>  orderItems = new ArrayList<OrderItem>();
	private Integer total;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
	 * public Integer getItemId() { return itemId; }
	 * 
	 * public void setItemId(Integer itemId) { this.itemId = itemId; }
	 */

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> itemList) {
		this.orderItems = itemList;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customerName=" + customerName + ", orderDate=" + orderDate + ", shippingAddress="
				+ shippingAddress + ", orderItems=" + orderItems + ", total=" + total + "]";
	}
}
