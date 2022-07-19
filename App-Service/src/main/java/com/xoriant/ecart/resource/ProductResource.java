package com.xoriant.ecart.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.ecart.dto.ProductDTO;
import com.xoriant.ecart.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/products")
@Slf4j
public class ProductResource {

	@Autowired
	private ProductService productService;

	@PostMapping("/save")
	public ResponseEntity<String> addNewCategory(@RequestBody ProductDTO productDTO) {
		String result = productService.addNewCategory(productDTO);
		log.info("addNewCategory() called");
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	@PostMapping("/saveAll")
	public ResponseEntity<String> addNewListsCategories(@RequestBody List<ProductDTO> productDTO) {
		String result = productService.addNewListsCategories(productDTO);
		log.info("addNewListsCategories() called");
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateCategory(@RequestBody ProductDTO productDTO) {
		String result = productService.updateCategory(productDTO);
		log.info("updateCategory() called");
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
}