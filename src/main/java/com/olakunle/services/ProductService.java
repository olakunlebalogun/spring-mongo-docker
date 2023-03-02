package com.olakunle.services;

import com.olakunle.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    String addProduct(Product product);

    Product getProduct(Long id);
}

