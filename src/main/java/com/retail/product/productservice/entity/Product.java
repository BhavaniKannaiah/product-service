package com.retail.product.productservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Entity created for the product POJOs
 * @author bhava
 *
 */
//Enable below commented section if you want them to behave as entity.	
//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	private String name;

	public CurrentPrice getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(CurrentPrice currentPrice) {
		this.currentPrice = currentPrice;
	}


	private CurrentPrice currentPrice;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
