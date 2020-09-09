package com.order.service.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.service.entity.Order;
import com.order.service.repository.OrderRepository;

import java.util.List;

@Service
public class OrderServiceModel {
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	
	public List<Order> getOrders() {
		return orderRepository.findAll();
	}

}
