package com.dio.microsservicos.storefront.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.microsservicos.storefront.dto.PurchaseDTO;
import com.dio.microsservicos.storefront.services.PurchaseService;

@RestController
@RequestMapping(value = "/purchases")
public class PurchaseController {

	@Autowired
	private PurchaseService service;

	@PostMapping
	public ResponseEntity<String> createPurchase(@RequestBody PurchaseDTO purchase) {
		service.sendPurchase(purchase);
		return ResponseEntity.ok("Pedido de compra enviado para processamento!");
	}
}