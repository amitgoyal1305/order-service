package com.order.service.utill;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.order.service.entity.Order;
import com.order.service.exception.OrderNotFoundException;
import com.order.service.model.OrderItems;
import com.order.service.proxy.OrderItemServiceProxy;
import com.order.service.request.OrderItemUpdateRequest;
import com.order.service.request.OrderRequest;
import com.order.service.response.OrderResponse;

@Component
public class OrderMapperUtill {

	@Autowired
	private OrderItemServiceProxy orderItemServiceProxy;

	public List<OrderResponse> getOrderToOrderResponse(List<Order> orders) {

		List<OrderResponse> orderResponses = new ArrayList<OrderResponse>();

		/*
		 * List<OrderItems> findAllOrderItems =
		 * orderItemServiceProxy.findAllOrderItems();
		 * 
		 * 
		 * 
		 * for (OrderItems orderItems : findAllOrderItems) {
		 * System.out.println(orderItems.toString()); }
		 */

		System.out.println(orderItemServiceProxy.getItemsById(11103).toString());

		return orderResponses;

	}

	public Order convertOrderRequestToOrder(OrderRequest request) throws OrderNotFoundException {

		Order order = new Order();
		order.setCustomerName(request.getCustomerName());
		order.setOrderDate(request.getOrderDate());
		order.setShippingAddress(request.getShippingAddress());
		
		OrderItems items = orderItemServiceProxy.getItemsById(request.getItemId());
		if(items == null || items.getProductName().isEmpty() || items.getProductName().equals("")) {
			throw new OrderNotFoundException("Item Not Found");
		}else {
			if(!(items.getQuantity() >= request.getQuantity())) {
				throw new OrderNotFoundException("Item Quantity is not available");
			}else {
				OrderItemUpdateRequest orderItemUpdateRequest = new OrderItemUpdateRequest();
				orderItemUpdateRequest.setId(request.getItemId());
				orderItemUpdateRequest.setQuantity(items.getQuantity() - request.getQuantity());
				orderItemServiceProxy.updateItem(orderItemUpdateRequest);
			}
		}
		order.setItemId(request.getItemId());
		order.setTotal(request.getPrice() * request.getQuantity());
		
		
		/*
		 * List<OrderItems> findAllOrderItems =
		 * orderItemServiceProxy.findAllOrderItems();
		 * 
		 * 
		 * 
		 * for (OrderItems orderItems : findAllOrderItems) {
		 * System.out.println(orderItems.toString()); }
		 */
		return order;

	}

}
