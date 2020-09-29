package com.order.utill;

import java.util.List;

import org.springframework.stereotype.Component;

import com.order.entity.Order;
import com.order.entity.OrderItem;
import com.order.exception.OrderNotFoundException;
import com.order.request.OrderRequest;

@Component
public class OrderMapperUtill {

	public Order convertOrderRequestToOrder(OrderRequest request) throws OrderNotFoundException {

		Order order = new Order();
		order.setCustomerName(request.getCustomerName());
		order.setOrderDate(request.getOrderDate());
		order.setShippingAddress(request.getShippingAddress());
		List<OrderItem> itemList = request.getOrderItems();
		int total = 0;
		for (OrderItem item : request.getOrderItems()) {
			
			  	total = total + request.getPrice() * item.getQuantity();
			}
		order.setOrderItems(itemList);
		order.setTotal(total);
		return order;

	}

}
