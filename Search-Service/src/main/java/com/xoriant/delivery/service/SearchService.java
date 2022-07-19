package com.xoriant.delivery.service;

import java.util.List;
import java.util.Optional;
import com.xoriant.delivery.model.Product;

public interface SearchService {

	Optional<Product> findByProductName(String productName);

	public Optional<Product> findByProductId(int productId);

	public List<Product> findAllProducts();

	public List<Product> findByBrandName(String brandName);

	public List<Product> findByCategoryName(String categoryName);

	public List<Product> findByPriceInBetween(double minPrice, double maxPrice);

	public List<Product> findByPriceGreaterThan(double minPrice);

	public List<Product> findByPriceLessThan(double minPrice);
}
