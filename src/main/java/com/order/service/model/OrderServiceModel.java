package com.order.service.model;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.service.entity.Order;
import com.order.service.exception.OrderNotFoundException;
import com.order.service.repository.OrderRepository;
import com.order.service.request.OrderRequest;
import com.order.service.response.OrderResponse;
import com.order.service.utill.OrderMapperUtill;

@Service
public class OrderServiceModel {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderMapperUtill orderMapperUtill;

	public Order getRestTemplate(Integer id) throws OrderNotFoundException {
		try {
			return orderRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new OrderNotFoundException("Order Not Found");
		}
	}

	public List<OrderResponse> getOrders() {
		List<OrderResponse> orderResponses = orderMapperUtill.getOrderToOrderResponse(orderRepository.findAll());
		return orderResponses;
	}

	public void orderCreate(OrderRequest request) throws OrderNotFoundException {
		Order order= orderMapperUtill.convertOrderRequestToOrder(request);
		orderRepository.save(order);
	}

}
