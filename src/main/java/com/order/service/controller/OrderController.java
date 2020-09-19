package com.order.service.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.order.service.entity.Order;
import com.order.service.exception.OrderNotFoundException;
import com.order.service.model.OrderServiceModel;
import com.order.service.request.OrderRequest;
import com.order.service.response.OrderResponse;

@RestController
public class OrderController {

	@Autowired
	private OrderServiceModel orderService;

	@Autowired
	RestTemplate restTemplate;


	@GetMapping("/order/{id}")
	public Order getOredrById(@PathVariable("id") Integer id) throws OrderNotFoundException {
		return orderService.getOredrById(id);
	}

	@GetMapping("/orders")
	public ResponseEntity<List<OrderResponse>> getOrders() {

		List<OrderResponse> orderResponses = orderService.getOrders();
		return new ResponseEntity<List<OrderResponse>>(orderResponses, HttpStatus.OK);
	}

	@PostMapping("/order/place")
	@Transactional(rollbackOn = Exception.class)
	public ResponseEntity<Object> createOrder(@RequestBody @Valid OrderRequest request) throws OrderNotFoundException {
		orderService.createOrder(request);
		return ResponseEntity.noContent().build();
	}

}
