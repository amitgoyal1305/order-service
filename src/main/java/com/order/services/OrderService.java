package com.order.services;

import java.util.List;

import com.order.exception.OrderNotFoundException;
import com.order.request.OrderRequest;
import com.order.response.OrderResponse;

public interface OrderService {
	
	public OrderResponse getOredrById(Integer id) throws OrderNotFoundException;
	
	public List<OrderResponse> getOrders();
	
	public void createOrder(OrderRequest request) throws OrderNotFoundException ;

}
