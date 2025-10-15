package com.dio.microsservicos.storefront.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.microsservicos.storefront.config.RabbitMQConfig;
import com.dio.microsservicos.storefront.dto.PurchaseDTO;

@Service
public class PurchaseService {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendPurchase(PurchaseDTO purchase) {
		System.out.println("Enviando pedido para a fila: " + purchase.getProductId());
		rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, purchase);
	}
}