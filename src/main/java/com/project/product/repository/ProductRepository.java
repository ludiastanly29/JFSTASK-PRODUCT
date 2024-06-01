package com.project.product.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.product.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {


}
