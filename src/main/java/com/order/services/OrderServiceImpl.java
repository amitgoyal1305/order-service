package com.order.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.entity.Order;
import com.order.exception.OrderNotFoundException;
import com.order.proxy.OrderProxyClient;
import com.order.request.OrderRequest;
import com.order.response.OrderResponse;
import com.order.utill.OrderMapperUtill;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	
	@Autowired
	private OrderMapperUtill orderMapperUtill;
	
	@Autowired 
	private OrderProxyClient orderProxyClient;
	

	public OrderResponse getOredrById(Integer id) throws OrderNotFoundException {
		try {
			OrderResponse oredrById = orderProxyClient.getOredrById(id);
			if(null == oredrById)
				throw new NoSuchElementException();
			return oredrById;
		} catch (NoSuchElementException e) {
			throw new OrderNotFoundException("Order Not Found");
		}
	}

	public List<OrderResponse> getOrders() {
		List<OrderResponse> orderResponses = orderProxyClient.getOrders();
		return orderResponses;
	}

	public void createOrder(OrderRequest request) throws OrderNotFoundException {
		Order order= orderMapperUtill.convertOrderRequestToOrder(request);
		orderProxyClient.createOrder(order);
	}

}
