package com.shoppingcart.order.service;

import com.shoppingcart.order.dto.OrderDto;

public interface OrderService {

	public OrderDto createOrderProducts(OrderDto order);
}
