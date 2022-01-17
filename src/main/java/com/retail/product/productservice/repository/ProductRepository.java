package com.retail.product.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retail.product.productservice.entity.Product;
/**
 * Repository class to connect to the back end system.
 * @author bhava
 *
 */
@Repository
public interface ProductRepository //extends JpaRepository<Product,Long>
{

	Product findByProductId(Long id);

}
