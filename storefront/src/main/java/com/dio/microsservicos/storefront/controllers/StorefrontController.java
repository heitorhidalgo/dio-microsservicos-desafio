package com.dio.microsservicos.storefront.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.microsservicos.storefront.dto.ProductDTO;
import com.dio.microsservicos.storefront.services.StorefrontService;

@RestController
@RequestMapping(value = "/storefront")
public class StorefrontController {

	@Autowired
	private StorefrontService service;

	@GetMapping(value = "/products")
	public ResponseEntity<ProductDTO[]> getProductsFromWarehouse() {
		ProductDTO[] products = service.findAllProducts();
		return ResponseEntity.ok(products);
	}
}