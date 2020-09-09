package com.order.service.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import com.order.service.entity.Order;
import com.order.service.exception.OrderNotFoundException;
import com.order.service.model.OrderItems;
import com.order.service.model.OrderServiceModel;
import com.order.service.proxy.OrderItemServiceProxy;
import com.order.service.repository.OrderRepository;
import com.order.service.request.OrderItemUpdateRequest;
import com.order.service.request.OrderRequest;
import com.order.service.response.OrderResponse;
import com.order.service.utill.OrderMapperUtill;

@RestController
//@Validated
public class OrderController {
	
	@Autowired 
	private OrderServiceModel orderServiceModel;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private OrderItemServiceProxy orderItemServiceProxy;
	
	@Autowired
	private OrderMapperUtill orderMapperUtill;
	
	@Autowired
	private OrderRepository orderRepository; 

	@GetMapping("/order/{id}")
	public Order getRestTemplate(@PathVariable("id") Integer id) throws OrderNotFoundException {
		try {
			return orderRepository.findById(id).get();
		}catch (NoSuchElementException e) {
			throw new OrderNotFoundException("Order Not Found");
		}
	}
	
	
	
	@GetMapping("/orders")
	public ResponseEntity<List<OrderResponse>> getOrders() {
		
		List<OrderResponse> orderResponses = orderMapperUtill.getOrderToOrderResponse(orderServiceModel.getOrders());
		
		List<OrderItems> findAllOrderItems = orderItemServiceProxy.findAllOrderItems();
		for (OrderItems orderItems : findAllOrderItems) {
			System.out.println(orderItems.toString());
		}
		
		return new ResponseEntity<List<OrderResponse>>(orderResponses,HttpStatus.OK);
	}
	
	
	@PostMapping("/order/place")
	@Transactional(rollbackOn = Exception.class)
	public ResponseEntity<Object> orderCreate(@RequestBody @Valid OrderRequest request) throws OrderNotFoundException{
		
		System.out.println(request.toString());
		 
		Order order = orderMapperUtill.convertOrderRequestToOrder(request);

		orderRepository.save(order);
		
		return ResponseEntity.noContent().build();
	}
	
	
}
