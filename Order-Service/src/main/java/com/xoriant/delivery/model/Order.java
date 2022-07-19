package com.xoriant.delivery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int orderId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "total_amount")
	private double totalAmount;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "keywords")
	private String keywords;

	@Column(name = "brand_name")
	private String brandName;

	@Column(name = "category_name")
	private String categoryName;
}
