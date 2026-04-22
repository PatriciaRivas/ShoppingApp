package com.shoppingcart.products.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.shoppingcart.products.dto.ProductDto;

@Service
public class ProductServiceImpl implements ProductService {

	private final RestClient restClient;
	
	public ProductServiceImpl(RestClient.Builder builder) {
		this.restClient = builder.baseUrl("https://fakestoreapi.com/").build();
	}
	
	@Override
	public List<ProductDto> getProductList() {
		return restClient.get()
				.uri("products")
				.retrieve()
				.body(new ParameterizedTypeReference<List<ProductDto>>(){} );
	}

	@Override
	public ProductDto getProductById(Integer productId) {
		return restClient.get()
		.uri("products/{id}", productId)
		.retrieve()
		.body(new ParameterizedTypeReference<ProductDto>(){} );
	}

	
	

}
