package com.shoppingcart.payment.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.shoppingcart.payment.dto.PaymentDto;
import com.shoppingcart.payment.enums.PaymentStatus;

@Repository
public class PaymentRepository {

	private final List<PaymentDto> paymentRegistry= new ArrayList<PaymentDto>();
	private final AtomicInteger sequence= new AtomicInteger(1);
	
	public PaymentDto processPayment(PaymentDto payment) {		
		payment.setPaymentId(sequence.getAndIncrement());
		payment.setStatus(PaymentStatus.PROCESSED);
		
		return payment;
	}
	
	public List<PaymentDto> getPaymentRegistry(){
		return paymentRegistry;
	}
	
	public PaymentDto getPaymentByOrderId(Integer orderId) {
		return paymentRegistry.stream().filter(payment -> orderId.equals(payment.getOrderId())).findFirst().orElse(null);
	}
}
