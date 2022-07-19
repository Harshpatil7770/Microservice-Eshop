package com.xoriant.delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	private int productId;

	private String productName;

	private double price;

	private int quantity;

	private String keywords;

	private String brandName;

	private String categoryName;
}
