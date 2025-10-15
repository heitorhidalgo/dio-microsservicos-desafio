package com.dio.microsservicos.warehouse.consumers;

import java.util.Optional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dio.microsservicos.warehouse.dto.PurchaseDTO;
import com.dio.microsservicos.warehouse.entities.Product;
import com.dio.microsservicos.warehouse.repositories.ProductRepository;

@Component
public class PurchaseConsumer {

	@Autowired
	private ProductRepository productRepository;

	@RabbitListener(queues = "purchases.queue")
	public void receivePurchase(PurchaseDTO purchase) {
		System.out.println(">>> Mensagem de compra recebida: Produto ID " + purchase.getProductId() + ", Quantidade "
				+ purchase.getQuantity());

		Optional<Product> productOpt = productRepository.findById(purchase.getProductId());

		if (productOpt.isPresent()) {
			Product product = productOpt.get();

			int newQuantity = product.getQuantity() - purchase.getQuantity();
			product.setQuantity(newQuantity);

			productRepository.save(product);

			System.out.println(">>> Estoque do produto '" + product.getName() + "' atualizado para: " + newQuantity);
		} else {
			System.err.println("!!! Produto com ID " + purchase.getProductId() + " não encontrado no estoque. !!!");
		}
	}
}