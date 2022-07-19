package com.xoriant.ecart.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.ecart.dto.ProductDTO;
import com.xoriant.ecart.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductResource {

	@Autowired
	private ProductService productService;

	@PostMapping("/save/{brandId}/{categoryId}")
	public ResponseEntity<String> addNewProduct(@RequestBody ProductDTO productDTO, @PathVariable int brandId,
			@PathVariable int categoryId) {
		String result = productService.addNewProduct(productDTO, brandId, categoryId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
