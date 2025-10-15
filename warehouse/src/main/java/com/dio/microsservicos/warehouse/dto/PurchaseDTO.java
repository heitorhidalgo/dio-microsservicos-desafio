package com.dio.microsservicos.warehouse.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PurchaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long productId;
	private Integer quantity;
}