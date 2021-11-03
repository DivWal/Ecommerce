package com.product.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.product.demo.dao.ProductDao;
import com.product.demo.entities.Product;

public interface ProductService {
	
	public List<Product> getProduct();

	public Optional<Product> getProduct(String productId);

	public Product addProduct(Product product);

	public void deleteProduct(String productId);

	public void updateProduct(Product product);

	public void saveAll(List<Product> products);

	public List<Product> searchbyName(String name);

}
