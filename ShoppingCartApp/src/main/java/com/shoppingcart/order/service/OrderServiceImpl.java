package com.shoppingcart.order.service;

import org.springframework.stereotype.Service;

import com.shoppingcart.order.dao.OrderRepository;
import com.shoppingcart.order.dto.OrderDto;
import com.shoppingcart.order.dto.OrderResponse;
import com.shoppingcart.products.dto.ProductDto;
import com.shoppingcart.utils.exception.BadRequestException;

@Service
public class OrderServiceImpl implements OrderService {
	
	private final OrderRepository orderRepository;

	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository=orderRepository;
	}
	
	@Override
	public OrderResponse createOrderProducts(OrderDto order) {
		
		if (order==null) {
			throw new BadRequestException("Order cannot be null");
		}
		if(order.getProducts()==null || order.getProducts().isEmpty()) {
			throw new BadRequestException("Order must containt at least one product");
		}

		OrderDto orderSaved =  orderRepository.saveOrder(order);
		
		Double total = 0.0;
		for(ProductDto product : orderSaved.getProducts()) {
			if(product==null) {
				throw new BadRequestException("Product cannot be null");
			}
			if(product.getPrice()==null) {
				throw new BadRequestException("Product price is required");
			}
			if(product.getPrice()<=0) {
				throw new BadRequestException("Product price should be greater than 0");
			}
			total+=product.getPrice();
		}
		
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setOrderId(orderSaved.getId());
		orderResponse.setTotal(total);
		orderResponse.setStatus("PAYMENT_PENDING");
		
		return orderResponse;
	}

}
