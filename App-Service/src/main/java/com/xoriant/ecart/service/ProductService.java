package com.xoriant.ecart.service;

import com.xoriant.ecart.dto.ProductDTO;

public interface ProductService {

	String addNewProduct(ProductDTO productDTO,int brandId,int categoryId);

//	String addNewListsProducts(List<ProductDTO> productDTO);
//
//	String updateProduct(ProductDTO productDTO);
//
//	String updateListsProduct(List<ProductDTO> productDTO);
//
//	void deleteProduct(int productId);
//
//	Optional<Product> findByProductName(String productName);
//
//	Optional<Product> findByProductId(int productId);
//
//	List<Product> findAllProducts();
//
//	List<Product> findByBrandName(String brandName);
//
//	List<Product> findByCategoryName(String categoryName);
//
//	List<Product> findByPriceInBetween(double minPrice, double maxPrice);
//
//	List<Product> findByPriceGreaterThan(double minPrice);
//
//	List<Product> findByPriceLessThan(double minPrice);
	
//	Optional<Brand> findByBrandId(int brandId);

}
