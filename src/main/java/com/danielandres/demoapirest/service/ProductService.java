package com.danielandres.demoapirest.service;

import com.danielandres.demoapirest.domain.Product;

import java.util.Set;

public interface ProductService {
    Set<Product> findAllProductsVisible(boolean visible);

    Set<Product> findByCategory(String category);

    Product addProduct(Product product);

    void updateProductName(long id, String name);

    void deleteProduct(long id);
}
