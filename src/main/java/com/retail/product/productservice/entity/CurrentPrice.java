package com.retail.product.productservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Entity created for the CurrentPrice POJOs.
 * @author bhava
 *
 */
//Enable below commented section if you want them to behave as entity.	

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentPrice {

	private static double CURRENCY = 13.49;
	private static String CURRENCY_CODE = "USD";
	//Enable below commented section if you want them to behave as entity.	
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long currencyId;

	private double value;
	private String currencyCode;	
	public CurrentPrice() {
	}

	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = CURRENCY;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = CURRENCY_CODE;
	}

	public CurrentPrice(double value, String currencyCode) {
		this.value =value;
		this.currencyCode = currencyCode;

	}


}
