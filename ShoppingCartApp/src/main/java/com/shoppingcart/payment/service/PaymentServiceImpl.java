package com.shoppingcart.payment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shoppingcart.order.dto.OrderDto;
import com.shoppingcart.order.enums.OrderStatus;
import com.shoppingcart.order.repository.OrderRepository;
import com.shoppingcart.payment.dto.PaymentDto;
import com.shoppingcart.payment.repository.PaymentRepository;
import com.shoppingcart.utils.exception.BadRequestException;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	private final PaymentRepository paymentRepository;
	private final OrderRepository orderRepository;
	
	public PaymentServiceImpl(PaymentRepository paymentRepository, OrderRepository orderRepository) {
		this.paymentRepository=paymentRepository;
		this.orderRepository=orderRepository;
	}

	@Override
	public PaymentDto processPayment(PaymentDto payment) {
		if(payment.getOrderId()==null) {
			throw new BadRequestException("Order information is required to process the payment");
		}
		
		PaymentDto paymentVerify = paymentRepository.getPaymentByOrderId(payment.getOrderId());
		if(paymentVerify!=null) {
			throw new BadRequestException("Payment has already been processed for this order");
		}
		PaymentDto paymentProcessed = paymentRepository.processPayment(payment);
		if(paymentProcessed.getStatus().equals("PROCESSED")) {
			OrderDto order = orderRepository.getOrderById(payment.getOrderId());
			order.setStatus(OrderStatus.PAID);
			orderRepository.saveOrder(order);
		}
		return paymentProcessed;
	}

	@Override
	public List<PaymentDto> getPaymentRegistryByUser(Integer userId) {
		List<PaymentDto> userPaymentList = new ArrayList<PaymentDto>();
		
		for(PaymentDto payment : paymentRepository.getPaymentRegistry()) {
			OrderDto order = orderRepository.getOrderById(payment.getOrderId());
			if(order.getUserId()==userId) {
				userPaymentList.add(payment);
			}
		}
			
		return userPaymentList;
	}
	
	

}
