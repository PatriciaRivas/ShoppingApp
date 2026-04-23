package com.shoppingcart.payment.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.payment.dto.PaymentDto;
import com.shoppingcart.payment.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	private final PaymentService paymentService;
	
	public PaymentController(PaymentService paymentService) {
		this.paymentService=paymentService;
	}
	
	@GetMapping("/get-payments-registry-by-user/{userId}")
	public ResponseEntity<List<PaymentDto>> getPaymentRegistryByUser(@PathVariable Integer userId){
		return ResponseEntity.ok(paymentService.getPaymentRegistryByUser(userId));
	}

	@PostMapping("/process-payment")
	public ResponseEntity<PaymentDto> processPayment(@RequestBody PaymentDto payment){
		return ResponseEntity.ok(paymentService.processPayment(payment));
	}
}
