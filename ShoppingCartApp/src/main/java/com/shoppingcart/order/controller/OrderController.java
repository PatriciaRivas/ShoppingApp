package com.shoppingcart.order.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.order.dto.OrderDto;
import com.shoppingcart.order.dto.OrderResponse;
import com.shoppingcart.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	private final OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService=orderService;
	}
	
	@PostMapping(value="/create-new-order", produces = {"application/json"})
	public ResponseEntity<Object> createOrderProducts(@RequestBody OrderDto order){
		OrderResponse orderResponse= orderService.createOrderProducts(order);
		return ResponseEntity.ok(orderResponse);
	}
	
}
