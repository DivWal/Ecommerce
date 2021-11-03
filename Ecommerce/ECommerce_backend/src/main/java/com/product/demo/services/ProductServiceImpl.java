package com.product.demo.services;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import com.product.demo.dao.ProductDao;
import com.product.demo.entities.Product;

@Service
@EnableMongoRepositories("com.product.demo.dao")
public class ProductServiceImpl implements ProductService {


	@Autowired
	private ProductDao productdao;

	public ProductServiceImpl() {
	}
	
	
	@Override
	public List<Product> getProduct() {
		return productdao.findAll();
	}

	@Override
	public Optional<Product> getProduct(String productId) {
		return productdao.findById(productId);
	}

	@Override
	public Product addProduct(Product product) {
		productdao.save(product);
		return product;
	}

	@Override
	public void deleteProduct(String productId) {
		productdao.deleteById(productId);
	}

	@Override
	public void updateProduct(Product product) {
		productdao.save(product);
	}


	@Override
	public void saveAll(List<Product> products) {
		for(Product product:products)
		{
		  productdao.save(product);
		}
		
	}

	@Override
	public  List<Product> searchbyName(String name) {
	
		
		return productdao.search(name);
		
	}

}
