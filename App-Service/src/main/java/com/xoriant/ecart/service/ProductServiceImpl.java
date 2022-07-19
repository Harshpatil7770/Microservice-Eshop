package com.xoriant.ecart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.ecart.dao.CategoryRepo;
import com.xoriant.ecart.dao.ProductRepo;
import com.xoriant.ecart.dto.ProductDTO;
import com.xoriant.ecart.exception.InputUserException;
import com.xoriant.ecart.model.Brand;
import com.xoriant.ecart.model.Category;
import com.xoriant.ecart.model.Product;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	private Category category;

	private Brand brand;

	private Product product;

	private static final String NEW_CATEGORY_ADDED = "New Category Added Succesfully !";

	private static final String NEW_LISTS_OF_CATEGORY_ADDED = "New Lists Of Category Added Succesfully !";

	private static final String UPDATE_EXISTING_CATEGORY = "Update Existing Category Succesfully !";

	@Override
	public String addNewCategory(ProductDTO productDTO) {

		if (productDTO.getCategoryName().isBlank() || productDTO.getCategoryName().isEmpty()) {
			throw new InputUserException();
		}
		category = new Category();
		category.setCategoryName(productDTO.getCategoryName().toUpperCase());
		categoryRepo.save(category);
		log.info("addNewCategory() called");
		return NEW_CATEGORY_ADDED;
	}

	@Override
	public String addNewListsCategories(List<ProductDTO> productDTO) {
		for (ProductDTO newProduct : productDTO) {
			if (newProduct.getCategoryName().isBlank() || newProduct.getCategoryName().isEmpty()) {
				throw new InputUserException();
			}
		}

		for (ProductDTO newProduct : productDTO) {
			category = new Category();
			category.setCategoryName(newProduct.getCategoryName().toUpperCase());
			categoryRepo.save(category);
		}
		log.info("addNewListsCategories() called");
		return NEW_LISTS_OF_CATEGORY_ADDED;
	}

	@Override
	public String updateCategory(ProductDTO productDTO) {

		if (productDTO.getCategoryName().isBlank() || productDTO.getCategoryName().isEmpty()) {
			throw new InputUserException();
		}
		category = new Category();
		category.setCategoryName(productDTO.getCategoryName().toUpperCase());
		categoryRepo.save(category);
		log.info("updateCategory() called");
		return UPDATE_EXISTING_CATEGORY;
	}

	@Override
	public String updateListsCategory(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCategory(int categoryId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Category findByCategoryName(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

}