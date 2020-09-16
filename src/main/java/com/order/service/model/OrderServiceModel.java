package com.order.service.model;

import java.util.List;

import com.order.service.entity.Order;
import com.order.service.exception.OrderNotFoundException;
import com.order.service.request.OrderRequest;
import com.order.service.response.OrderResponse;

public interface OrderServiceModel {
	
	public Order getRestTemplate(Integer id) throws OrderNotFoundException;
	
	public List<OrderResponse> getOrders();
	
	public void orderCreate(OrderRequest request) throws OrderNotFoundException ;

}
