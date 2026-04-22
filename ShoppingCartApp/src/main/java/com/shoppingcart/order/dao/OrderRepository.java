package com.shoppingcart.order.dao;

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
		OrderDto orderUser = getOrderByUserId(order.getUserId());
		if(orderUser!=null) {
			order.setId(orderUser.getId());
			
			List<ProductDto> productList= new ArrayList<ProductDto>();
			productList.addAll(order.getProducts());
			productList.addAll(productList);
			
			order.setProducts(productList);
		}
		if(order.getId()==null) {
			order.setId(sequence.getAndIncrement());
		}
		orders.add(order);
		return order;
	}
	
	public OrderDto getOrderById(Integer orderId) {
		return orders.stream().filter(order -> orderId.equals(order.getId())).findFirst().orElse(null);
	}
	
	public OrderDto getOrderByUserId(Integer userId) {
		return orders.stream().filter(order -> userId.equals(order.getUserId())).findFirst().orElse(null);
	}
}
