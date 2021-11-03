package com.product.demo.dao;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.product.demo.entities.Product;

@Repository
public interface ProductDao extends MongoRepository<Product,String>{
	
	@Query("SELECT p FROM Product p WHERE p.product_name LIKE %?1%"
            + " OR p.brand LIKE %?1%")
    public List<Product> search(String keyword);
	
}
