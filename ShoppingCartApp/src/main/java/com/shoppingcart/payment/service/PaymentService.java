package com.shoppingcart.payment.service;

import java.util.List;

import com.shoppingcart.payment.dto.PaymentDto;

public interface PaymentService {

	public PaymentDto processPayment(PaymentDto payment);
	
	public List<PaymentDto> getPaymentRegistryByUser(Integer userId);
}
