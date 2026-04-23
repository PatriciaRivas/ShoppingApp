package com.shoppingcart.order.dto;

import java.util.List;

import com.shoppingcart.order.enums.OrderStatus;
import com.shoppingcart.products.dto.ProductDto;

public class OrderDto {

	private Integer id;
	private Integer userId;
	private List<ProductDto> products;
	private Double total;
	private OrderStatus status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List<ProductDto> getProducts() {
		return products;
	}
	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	
}
