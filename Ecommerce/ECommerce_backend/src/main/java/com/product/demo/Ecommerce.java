package com.product.demo;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.demo.entities.Product;
import com.product.demo.services.ProductService;

@SpringBootApplication
public class Ecommerce {	
	
	
	@Autowired
	private ProductService productService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Ecommerce.class, args);
	}
	
	
	@Bean
    CommandLineRunner runner() {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Product>> typeReference = new TypeReference<List<Product>>() {
            };
            InputStream inputStream = TypeReference.class.getResourceAsStream("/product.json");
            try {
                List<Product> products = mapper.readValue(inputStream, typeReference);
                
                System.out.println("LENGTH noww" + products.size());

                productService.saveAll(products);

                System.out.println("Product List savedsuccesfully!");
            } catch (IOException e) {
                System.out.println("Unable to save product: " + e.getMessage());
            }
        };

    }
	
}





