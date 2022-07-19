package com.xoriant.delivery.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.delivery.dao.OrderRepo;
import com.xoriant.delivery.dto.Product;
import com.xoriant.delivery.exception.ElementNotFound;
import com.xoriant.delivery.exception.InputUserException;
import com.xoriant.delivery.model.Order;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo orderRepo;
	@Autowired
	private SearchServiceProxy searchServiceProxy;

	private Order order;

	@Override
	public Order addNewOrder(String productName, int quantity) {
		order = new Order();
		if (productName.isEmpty() || productName.isBlank()) {
			throw new InputUserException();
		}
		Product productResult = findByProductName(productName).orElse(null);
		order.setProductName(productResult.getProductName());
		double totalAmount = quantity * productResult.getPrice();
		order.setTotalAmount(totalAmount);
		order.setQuantity(quantity);
		order.setKeywords(productResult.getKeywords());
		order.setBrandName(productResult.getBrandName());
		order.setCategoryName(productResult.getCategoryName());
		return orderRepo.save(order);
	}

	@Override
	public Optional<Product> findByProductName(String productName) {
		Optional<Product> existingProduct = searchServiceProxy.findByProductName(productName);
		if (!existingProduct.isPresent()) {
			throw new ElementNotFound();
		}
		return existingProduct;
	}

	@Override
	public Optional<Product> findByProductId(int productId) {
		Optional<Product> existingProduct = searchServiceProxy.findByProductId(productId);
		if (!existingProduct.isPresent()) {
			throw new ElementNotFound();
		}
		return existingProduct;
	}

}
