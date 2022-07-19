package com.xoriant.delivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xoriant.delivery.model.Product;

@FeignClient(name = "product-service", url = "http://localhost:9091")
public interface ProductServiceProxy {

	@GetMapping("/api/products/find/{productName}")
	public Optional<Product> findByProductName(@PathVariable String productName);

    @GetMapping("/api/products/find-product/{productId}")
    public Optional<Product> findByProductId(@PathVariable int productId);

	@GetMapping("/api/products/findAll")
	public List<Product> findAllProducts();

	@GetMapping("/api/products/findAll/{brandName}")
	public List<Product> findByBrandName(@PathVariable String brandName);

	@GetMapping("/api/products/findAll/products/{categoryName}")
	public List<Product> findByCategoryName(@PathVariable String categoryName);

	@GetMapping("/api/products/findAll/{minPrice}/{maxPrice}")
	public List<Product> findByPriceInBetween(@PathVariable double minPrice, @PathVariable double maxPrice);

	@GetMapping("/api/products/find/products/{minPrice}")
	public List<Product> findByPriceGreaterThan(@PathVariable double minPrice);

	@GetMapping("/api/products/find/products/maxPrice/{minPrice}")
	public List<Product> findByPriceLessThan(@PathVariable double minPrice);
}
