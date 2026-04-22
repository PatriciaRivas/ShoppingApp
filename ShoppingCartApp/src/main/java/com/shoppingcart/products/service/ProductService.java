package com.shoppingcart.products.service;

import java.util.List;

import com.shoppingcart.products.dto.ProductDto;

public interface ProductService {

	public List<ProductDto> getProductList();
	
	public ProductDto getProductById(Integer productId);
}
