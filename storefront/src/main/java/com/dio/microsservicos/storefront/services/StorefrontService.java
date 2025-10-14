package com.dio.microsservicos.storefront.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dio.microsservicos.storefront.dto.ProductDTO;

@Service
public class StorefrontService {

	@Autowired
	private RestTemplate restTemplate;

	private final String WAREHOUSE_URL = "http://localhost:8080/products";

	public ProductDTO[] findAllProducts() {
		ProductDTO[] products = restTemplate.getForObject(WAREHOUSE_URL, ProductDTO[].class);
		return products;
	}
}