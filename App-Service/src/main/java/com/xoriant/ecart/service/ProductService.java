package com.xoriant.ecart.service;

import java.util.List;

import com.xoriant.ecart.dto.ProductDTO;
import com.xoriant.ecart.model.Category;

public interface ProductService {

	String addNewCategory(ProductDTO productDTO);

	String addNewListsCategories(List<ProductDTO> productDTO);

	String updateCategory(ProductDTO productDTO);

	String updateListsCategory(ProductDTO productDTO);
	
	void deleteCategory(int categoryId);
	
	Category findByCategoryName(String categoryName);
}
