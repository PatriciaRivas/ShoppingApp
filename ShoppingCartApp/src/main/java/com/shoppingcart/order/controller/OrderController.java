package com.shoppingcart.order.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.order.dto.OrderDto;
import com.shoppingcart.order.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	private final OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService=orderService;
	}
	
	@PostMapping(value="/create-new-order", produces = {"application/json"})
	public ResponseEntity<OrderDto> createOrderProducts(@RequestBody OrderDto order){
		OrderDto orderResponse= orderService.createOrderProducts(order);
		return ResponseEntity.ok(orderResponse);
	}
	
}
