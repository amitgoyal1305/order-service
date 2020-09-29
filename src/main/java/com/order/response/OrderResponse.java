package com.order.response;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.order.entity.OrderItem;

public class OrderResponse {

	@JsonIgnore
	private Integer id;
	private String customerName;
	private Date orderDate;
	private String shippingAddress;
	private Set<OrderItem> orderItems;
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



	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "OrderResponse [customerName=" + customerName + ", orderDate=" + orderDate + ", shippingAddress="
				+ shippingAddress + ", orderItems=" + orderItems + ", total=" + total + "]";
	}

}
