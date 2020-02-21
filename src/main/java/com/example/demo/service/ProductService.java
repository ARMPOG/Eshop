package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {

    void saveProduct(Product product);

    List<Product> findAllProduct();
}
