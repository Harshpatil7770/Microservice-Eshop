package com.xoriant.delivery.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.delivery.model.Product;
import com.xoriant.delivery.service.SearchService;

@RestController
@RequestMapping("/api/search")
public class SearchResource {

	@Autowired
	private SearchService searchService;

	@GetMapping("/api/products/find/{productName}")
	public Optional<Product> findByProductName(@PathVariable String productName) {
		return searchService.findByProductName(productName);
	}

	@GetMapping("/api/products/find-product/{productId}")
	public Optional<Product> findByProductId(@PathVariable int productId) {
		return searchService.findByProductId(productId);
	}

	@GetMapping("/api/products/findAll")
	public List<Product> findAllProducts() {
		return searchService.findAllProducts();
	}

	@GetMapping("/api/products/findAll/{brandName}")
	public List<Product> findByBrandName(@PathVariable String brandName) {
		return searchService.findByBrandName(brandName);
	}

	@GetMapping("/api/products/findAll/products/{categoryName}")
	public List<Product> findByCategoryName(@PathVariable String categoryName) {
		return searchService.findByCategoryName(categoryName);
	}

	@GetMapping("/api/products/findAll/{minPrice}/{maxPrice}")
	public List<Product> findByPriceInBetween(@PathVariable double minPrice, @PathVariable double maxPrice) {
		return searchService.findByPriceInBetween(minPrice, maxPrice);
	}

	@GetMapping("/api/products/find/products/{minPrice}")
	public List<Product> findByPriceGreaterThan(@PathVariable double minPrice) {
		return searchService.findByPriceGreaterThan(minPrice);
	}

	@GetMapping("/api/products/find/products/maxPrice/{minPrice}")
	public List<Product> findByPriceLessThan(@PathVariable double minPrice) {
		return searchService.findByPriceLessThan(minPrice);
	}
}
