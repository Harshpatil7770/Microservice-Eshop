package com.xoriant.ecart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.ecart.dao.ProductRepo;
import com.xoriant.ecart.dto.ProductDTO;
import com.xoriant.ecart.exception.InputUserException;
import com.xoriant.ecart.model.Brand;
import com.xoriant.ecart.model.Category;
import com.xoriant.ecart.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	private Product product;

	private BrandServiceImpl brandServiceImpl;

	private CategoryServiceImpl categoryServiceImpl;

	private static final String NEW_PRODUCT_ADDED = "New Product Added SuccesfullY !";

	@Override
	public String addNewProduct(ProductDTO productDTO, int brandId, int categoryId) {
		if (productDTO.getProductName().isEmpty() || productDTO.getProductName().isBlank()) {
			throw new InputUserException();
		}
		product = new Product();
		product.setProductId(productDTO.getProductId());

		brandServiceImpl = new BrandServiceImpl();
		Optional<Brand> brandResult = brandServiceImpl.findByBrandId(brandId);
		product.setBrandName(brandResult.get().getBrandName());

		categoryServiceImpl = new CategoryServiceImpl();
		Optional<Category> categoryResult = categoryServiceImpl.findByCategoryId(categoryId);
		product.setCategoryName(categoryResult.get().getCategoryName());

		product.setKeywords(productDTO.getKeywords());
		product.setPrice(productDTO.getPrice());
		product.setProductName(productDTO.getProductName());
		product.setQuantity(productDTO.getQuantity());
		productRepo.save(product);
		return NEW_PRODUCT_ADDED;
	}

}
