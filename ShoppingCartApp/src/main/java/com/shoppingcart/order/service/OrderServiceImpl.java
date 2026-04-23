package com.shoppingcart.order.service;

import org.springframework.stereotype.Service;

import com.shoppingcart.order.dto.OrderDto;
import com.shoppingcart.order.enums.OrderStatus;
import com.shoppingcart.order.repository.OrderRepository;
import com.shoppingcart.products.dto.ProductDto;
import com.shoppingcart.products.service.ProductService;
import com.shoppingcart.utils.exception.BadRequestException;

@Service
public class OrderServiceImpl implements OrderService {
	
	private final OrderRepository orderRepository;
	
	private final ProductService productService;

	public OrderServiceImpl(OrderRepository orderRepository, ProductService productService) {
		this.orderRepository=orderRepository;
		this.productService= productService;
	}
	
	@Override
	public OrderDto createOrderProducts(OrderDto order) {
		
		if (order==null) {
			throw new BadRequestException("Order cannot be null");
		}
		if(order.getProducts()==null || order.getProducts().isEmpty()) {
			throw new BadRequestException("Order must containt at least one product");
		}
		
		Double total = 0.0;
		int indexProduct =0;
		
		for(ProductDto product : order.getProducts()) {
			if(product==null || product.getId()==null) {
				throw new BadRequestException("Product cannot be null");
			}
			if(product.getPrice()==null) {
				throw new BadRequestException("Product price is required");
			}
			if(product.getPrice()<=0) {
				throw new BadRequestException("Product price should be greater than 0");
			}
			product = productService.getProductById(product.getId());
			order.getProducts().set(indexProduct, product);
			
			total+=product.getPrice();
			indexProduct++;
		}
		order.setTotal(total);
		order.setStatus(OrderStatus.PAYMENT_PENDING);
		
		return orderRepository.saveOrder(order);
	}

}
