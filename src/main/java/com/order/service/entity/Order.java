package com.order.service.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import io.swagger.annotations.ApiModel;

@Entity(name = "Orders")
@ApiModel(description = "All Details for Order Item Entity")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	private String customerName;
	private Date orderDate;
	private String shippingAddress;
	
	@OneToOne
	@JoinColumn(name = "itemId", referencedColumnName = "id")
	private OrderItem orderItem;
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

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customerName=" + customerName + ", orderDate=" + orderDate + ", shippingAddress="
				+ shippingAddress + ", orderItem=" + orderItem.toString() + ", total=" + total + "]";
	}

	
	

}
