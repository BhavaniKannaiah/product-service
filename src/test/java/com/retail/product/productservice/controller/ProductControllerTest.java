package com.retail.product.productservice.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.product.productservice.entity.CurrentPrice;
import com.retail.product.productservice.entity.Product;
import com.retail.product.productservice.service.ProductService;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

	@Autowired
	private MockMvc mocMvc;

	@MockBean
	ProductService productService;

	@Autowired
	ObjectMapper objectMapper;


	@BeforeEach
	public void setUp() {

	}

	@Test
	public void get_productById_returnOk() throws Exception{

		Product product = new Product();
		CurrentPrice currentPrice = new CurrentPrice(0.0,"USD");

		product.setCurrentPrice(currentPrice);
		product.setId("1");
		product.setName("Test");
		when(productService.getproductNameWithProductId("1")).thenReturn(product);
		mocMvc.perform(MockMvcRequestBuilders.get(
				"http://localhost:8080/products/1").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("id",is("1"))).andExpect(jsonPath("name",is("Test")));
	}
}
