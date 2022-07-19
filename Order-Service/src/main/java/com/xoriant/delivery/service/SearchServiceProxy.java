package com.xoriant.delivery.service;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xoriant.delivery.dto.Product;

@FeignClient(name = "search-service", url = "http://localhost:9092")
public interface SearchServiceProxy {

	@GetMapping("api/search/api/products/find/{productName}")
	public Optional<Product> findByProductName(@PathVariable String productName);

	@GetMapping("api/search/api/products/find-product/{productId}")
	public Optional<Product> findByProductId(@PathVariable int productId);
}
