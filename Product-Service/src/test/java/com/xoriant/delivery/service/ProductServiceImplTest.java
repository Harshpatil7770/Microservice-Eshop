package com.xoriant.delivery.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.xoriant.delivery.dao.ProductRepo;
import com.xoriant.delivery.dto.Brand;
import com.xoriant.delivery.dto.Category;
import com.xoriant.delivery.dto.ProductDTO;
import com.xoriant.delivery.model.Product;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

	@Mock
	private ProductRepo productRepo;

	@InjectMocks
	private ProductServiceImpl productServiceImpl;

	private BrandCategoryServiceProxy brandCategoryServiceProxy;

	private static final String NEW_PRODUCT_ADDED = "New Product Added Succesfully !";

	private ProductDTO productDTO;

	private Product product;

	private Category category;

	private Brand brand;

	@BeforeEach
	void setUp() {
		category = new Category(101, "Mobile");
		productDTO = new ProductDTO(101, "Mobile", 501, "OPPO", 1001, "Oppo F1f", 15999, 150, "Selfi Expert");
//		product = new Product(productDTO.getProductId(), productDTO.getProductName(), productDTO.getPrice(),
//				productDTO.getQuantity(), productDTO.getKeywords(), productDTO.getBrandName(),
//				productDTO.getCategoryName());
	}

	@Test
	void addNewProduct() {
		int brandId = 501;
		int categoryId = 101;

		product = new Product();
		product.setProductId(productDTO.getProductId());
		product.setProductName(productDTO.getProductName());
		product.setPrice(productDTO.getPrice());
		product.setQuantity(productDTO.getQuantity());
		product.setKeywords(productDTO.getKeywords());

		Optional<Category> existingCategory = Optional.of(category);
		when(brandCategoryServiceProxy.findByCategoryId(categoryId)).thenReturn(existingCategory);
		product.setCategoryName(existingCategory.get().getCategoryName());

		Optional<Brand> existingBrand = Optional.of(brand);
		when(brandCategoryServiceProxy.findByBrandId(brandId)).thenReturn(existingBrand);
		product.setBrandName(existingBrand.get().getBrandName());

		when(productRepo.save(product)).thenReturn(product);
		assertEquals(NEW_PRODUCT_ADDED, productServiceImpl.addNewProduct(productDTO, brandId, categoryId));
	}
}
