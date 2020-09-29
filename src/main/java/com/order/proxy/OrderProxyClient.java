package com.order.proxy;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.order.entity.Order;
import com.order.response.OrderResponse;

@FeignClient(name ="commons",url="http://localhost:8300")
public interface OrderProxyClient {
	
	@PostMapping("/order/place")
	public ResponseEntity<Object> createOrder(@RequestBody Order order) ;
	
	
	@GetMapping("/order/{id}")
	public OrderResponse getOredrById(@PathVariable("id") Integer id);
	
	@GetMapping("/orders")
	public List<OrderResponse> getOrders();
	
	
}
