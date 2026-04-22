package com.shoppingcart.order.service;

import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import com.shoppingcart.order.dao.OrderRepository;
import com.shoppingcart.order.dto.OrderDto;
import com.shoppingcart.order.dto.OrderResponse;
import com.shoppingcart.products.dto.ProductDto;

@Service
public class OrderServiceImpl implements OrderService {
	
	private final OrderRepository orderRepository;

	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository=orderRepository;
	}
	
	@Override
	public OrderResponse createOrderProducts(OrderDto order) {
		
		OrderDto orderSaved =  orderRepository.saveOrder(order);
		
		Double total = 0.0;
		for(ProductDto product : orderSaved.getProducts()) {
			
			total+=product.getPrice();
		}
		
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setOrderId(orderSaved.getId());
		orderResponse.setTotal(total);
		orderResponse.setStatus("PAYMENT_PENDING");
		
		return orderResponse;
	}

}
