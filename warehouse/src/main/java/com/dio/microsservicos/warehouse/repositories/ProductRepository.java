package com.dio.microsservicos.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.microsservicos.warehouse.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}