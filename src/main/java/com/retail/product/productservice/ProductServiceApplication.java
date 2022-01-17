package com.retail.product.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Start the SpringBoot application
 * @author bhava
 *
 */
@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		System.out.println("Inside the ProductServiceApplication class");
		SpringApplication.run(ProductServiceApplication.class, args);


	}

}
