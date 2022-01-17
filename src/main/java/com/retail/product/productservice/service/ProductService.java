package com.retail.product.productservice.service;

import org.springframework.stereotype.Service;

import com.retail.product.productservice.entity.Product;
/**
 * ProductService will act as a service layer to connect to the repository.
 * @author bhava
 *
 */
@Service
public class ProductService {
	//Enable the below code if the service speak to backend system
	
	
	/*
	 * @Autowired private ProductRepository productRepository;
	 */
	/*
	 * public Product saveProduct(Product product) { return
	 * productRepository.save(product); }
	 */
	/*
	 * public Product findById(Long id) { return
	 * productRepository.findByProductId(id); }
	 */
/**
 * This method will speak to the backend system and return the product information.
 * @param productId, accept the product id as input
 * @return product, return the product information
 */
	public Product getproductNameWithProductId(String productId) {
		System.out.println("getproductNameWithProductId in service");
		ProductItemHelper productItem = new ProductItemHelper();
		Product  product= productItem.getProductDescription(productId);
		return product;

	}

	public Product updateproductNameWithProductId(Product product) {
		// TODO Auto-generated method stub
		return product;
	}
}
