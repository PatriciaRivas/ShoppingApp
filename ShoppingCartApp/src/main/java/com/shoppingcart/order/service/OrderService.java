package com.shoppingcart.order.service;

import com.shoppingcart.order.dto.OrderDto;
import com.shoppingcart.order.dto.OrderResponse;

public interface OrderService {

	public OrderResponse createOrderProducts(OrderDto order);
}
