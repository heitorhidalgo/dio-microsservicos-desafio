package com.dio.microsservicos.warehouse.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.dio.microsservicos.warehouse.entities.Product;
import com.dio.microsservicos.warehouse.repositories.ProductRepository;

@Configuration
public class DataInitializer implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {

		Product p1 = new Product(null, "Smart TV 50 Polegadas", 15);
		Product p2 = new Product(null, "Notebook Gamer i7", 8);
		Product p3 = new Product(null, "Smartphone 256GB", 30);

		productRepository.saveAll(Arrays.asList(p1, p2, p3));

		System.out.println(">>> BANCO DE DADOS POPULADO COM DADOS INICIAIS <<<");
	}
}