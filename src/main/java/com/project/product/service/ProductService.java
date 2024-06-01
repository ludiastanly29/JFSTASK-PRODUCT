package com.project.product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.product.model.Product;
import com.project.product.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

	public Object getAllProducts() {
		 return repository.findAll();
	}

	public Product saveProduct(Product product) {
		 return repository.save(product);
		
	}

	public  Optional<Product>  getProductById(String id) {
		 return repository.findById(id);
	}

}
