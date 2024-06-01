package com.project.product.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "productDetails")
public class Product {
    @Id
    private String id;
    private String productName;
    private double price;
    private String category;
}
