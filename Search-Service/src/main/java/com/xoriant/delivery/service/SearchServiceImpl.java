package com.xoriant.delivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.delivery.exception.ElementNotFound;
import com.xoriant.delivery.model.Product;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private ProductServiceProxy productServiceProxy;

	@Override
	public Optional<Product> findByProductName(String productName) {
		Optional<Product> existingProduct = productServiceProxy.findByProductName(productName);
		if (!existingProduct.isPresent()) {
			throw new ElementNotFound();
		}
		return existingProduct;
	}

	@Override
	public Optional<Product> findByProductId(int productId) {
		Optional<Product> existingProduct = productServiceProxy.findByProductId(productId);
		if (!existingProduct.isPresent()) {
			throw new ElementNotFound();
		}
		return existingProduct;
	}

	@Override
	public List<Product> findAllProducts() {

		return productServiceProxy.findAllProducts();
	}

	@Override
	public List<Product> findByBrandName(String brandName) {
		List<Product> existingProduct = productServiceProxy.findByBrandName(brandName);
		if (existingProduct.isEmpty()) {
			throw new ElementNotFound();
		}
		return existingProduct;
	}

	@Override
	public List<Product> findByCategoryName(String categoryName) {
		List<Product> existingProduct = productServiceProxy.findByCategoryName(categoryName);
		if (existingProduct.isEmpty()) {
			throw new ElementNotFound();
		}
		return existingProduct;
	}

	@Override
	public List<Product> findByPriceInBetween(double minPrice, double maxPrice) {
		List<Product> existingProduct = productServiceProxy.findByPriceInBetween(minPrice, maxPrice);
		if (existingProduct.isEmpty()) {
			throw new ElementNotFound();
		}
		return existingProduct;
	}

	@Override
	public List<Product> findByPriceGreaterThan(double minPrice) {
		List<Product> existingProduct = productServiceProxy.findByPriceGreaterThan(minPrice);
		if (existingProduct.isEmpty()) {
			throw new ElementNotFound();
		}
		return existingProduct;
	}

	@Override
	public List<Product> findByPriceLessThan(double minPrice) {
		List<Product> existingProduct = productServiceProxy.findByPriceLessThan(minPrice);
		if (existingProduct.isEmpty()) {
			throw new ElementNotFound();
		}
		return existingProduct;
	}

}
