package com.shoppingcart.products.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.products.dto.ProductDto;
import com.shoppingcart.products.service.ProductService;

@RestController
public class ProductsController {
	
	private final ProductService productService;
	
	public ProductsController(ProductService productService) {
        this.productService = productService;
    }

	@GetMapping("/product/get-product-list")
	public ResponseEntity<Object> getProductList(){
		List<ProductDto> productList = productService.getProductList();
		return ResponseEntity.ok(productList);
	}
}
