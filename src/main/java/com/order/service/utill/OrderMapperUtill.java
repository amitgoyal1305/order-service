package com.order.service.utill;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.order.service.entity.Order;
import com.order.service.entity.OrderItem;
import com.order.service.exception.OrderNotFoundException;
import com.order.service.proxy.OrderItemServiceProxy;
import com.order.service.repository.OrderRepository;
import com.order.service.request.OrderItemUpdateRequest;
import com.order.service.request.OrderRequest;
import com.order.service.response.OrderResponse;

@Component
public class OrderMapperUtill {

	@Autowired
	private OrderItemServiceProxy orderItemServiceProxy;

	@Autowired
	OrderRepository orderRepository;

	public List<OrderResponse> getOrderToOrderResponse(List<Order> orders) {

		List<OrderResponse> orderResponses = new ArrayList<OrderResponse>();

		orders = orderRepository.findAll();

		for (Order o : orders) {
			OrderResponse res = new OrderResponse();
			res.setCustomerName(o.getCustomerName());
			res.setOrderDate(o.getOrderDate());
			OrderItem orderItems = orderItemServiceProxy.getItemsById(o.getOrderItem().getId());
			res.setOrderItems(orderItems);
			res.setShippingAddress(o.getShippingAddress());
			res.setTotal(o.getTotal());
			orderResponses.add(res);
		}

		return orderResponses;

	}
	
	
	public Order getOredrById(Order order) {
		order.setOrderItem(orderItemServiceProxy.getItemsById(order.getOrderItem().getId()));
		return order;
	}

	public Order convertOrderRequestToOrder(OrderRequest request) throws OrderNotFoundException {

		Order order = new Order();
		order.setCustomerName(request.getCustomerName());
		order.setOrderDate(request.getOrderDate());
		order.setShippingAddress(request.getShippingAddress());

		OrderItem items = orderItemServiceProxy.getItemsById(request.getItemId());
		if (items == null || items.getProductName().isEmpty() || items.getProductName().equals("")) {
			throw new OrderNotFoundException("Item Not Found");
		} else {
			if (!(items.getQuantity() >= request.getQuantity())) {
				throw new OrderNotFoundException("Item Quantity is not available");
			} else {
				OrderItemUpdateRequest orderItemUpdateRequest = new OrderItemUpdateRequest();
				orderItemUpdateRequest.setId(request.getItemId());
				orderItemUpdateRequest.setQuantity(items.getQuantity() - request.getQuantity());
				orderItemServiceProxy.updateItem(orderItemUpdateRequest);
			}
		}
		order.setOrderItem(items);
		order.setTotal(request.getPrice() * request.getQuantity());
		return order;

	}

}
