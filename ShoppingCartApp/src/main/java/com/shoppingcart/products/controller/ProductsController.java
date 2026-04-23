package com.shoppingcart.products.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.products.dto.ProductDto;
import com.shoppingcart.products.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductsController {
	
	private final ProductService productService;
	
	public ProductsController(ProductService productService) {
        this.productService = productService;
    }

	@GetMapping("/get-product-list")
	public ResponseEntity<List<ProductDto>> getProductList(){
		List<ProductDto> productList = productService.getProductList();
		return ResponseEntity.ok(productList);
	}
}
