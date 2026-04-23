package com.shoppingcart.order.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.shoppingcart.order.dto.OrderDto;
import com.shoppingcart.products.dto.ProductDto;

@Repository
public class OrderRepository {

	private final List<OrderDto> orders = new ArrayList<OrderDto>();
	private final AtomicInteger sequence = new AtomicInteger(1);
	
	public OrderDto saveOrder(OrderDto order) {
		OrderDto orderUser = this.getOrderByUserId(order.getUserId());
		if(orderUser!=null) {
			order.setOrderId(orderUser.getOrderId());
		}
		if(order.getOrderId()==null) {
			order.setOrderId(sequence.getAndIncrement());
		}
		orders.add(order);
		return order;
	}
	
	public OrderDto getOrderById(Integer orderId) {
		return orders.stream().filter(order -> orderId.equals(order.getOrderId())).findFirst().orElse(null);
	}
	
	public OrderDto getOrderByUserId(Integer userId) {
		return orders.stream().filter(order -> userId.equals(order.getUserId())).findFirst().orElse(null);
	}
}
