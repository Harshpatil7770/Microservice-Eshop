package com.xoriant.delivery.service;

import java.util.Optional;

import com.xoriant.delivery.dto.Product;
import com.xoriant.delivery.model.Order;

public interface OrderService {

	Order addNewOrder(String productName,int quantity);

	public Optional<Product> findByProductName(String productName);

	public Optional<Product> findByProductId(int productId);
}
