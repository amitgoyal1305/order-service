package com.order.service.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.order.service.model.OrderItems;
import com.order.service.request.OrderItemUpdateRequest;

@FeignClient(name ="order-item-service",url="http://localhost:8200")
public interface OrderItemServiceProxy {
	@GetMapping("/order/items")
	public List<OrderItems> findAllOrderItems();
	
	
	@GetMapping("/order/item/{id}")
	public OrderItems getItemsById(@PathVariable Integer id);
	
	@PutMapping("/order/item/update")
	public  ResponseEntity<Object> updateItem(@RequestBody OrderItemUpdateRequest orderItemUpdateRequest);

}
