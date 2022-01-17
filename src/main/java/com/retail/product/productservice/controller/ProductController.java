package com.retail.product.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retail.product.productservice.entity.Product;
import com.retail.product.productservice.service.ProductService;

import lombok.extern.slf4j.Slf4j;
/**
 * Controler to invoke the GET and PUT METHOD.
 * @author bhava
 *
 */
@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {
	@Autowired
	private ProductService productService;

	/**
	 * Get method for product service by Id.
	 * @param id, accept the product Id
	 * @return product, information about the product
	 */
	@GetMapping("/{id}")
	public Product findProductById(@PathVariable("id") String id) {
		System.out.println("inside findproductById in ProductController method");
		return productService.getproductNameWithProductId(id);
	}

/**
 * PUT method to update the product service by Id.
 * @param product, accept the product id
 * @return product, information about the product
 */
	@PutMapping("/{id}")
	public Product  updateProductWithId( @RequestBody Product product) { return
			productService.updateproductNameWithProductId(product);

	}

}
