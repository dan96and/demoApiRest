package com.danielandres.demoapirest.service.impl;

import com.danielandres.demoapirest.domain.Product;
import com.danielandres.demoapirest.repository.ProductRepository;
import com.danielandres.demoapirest.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Set<Product> findAllProductsVisible(boolean visible) {
        return productRepository.findAllByVisible(visible);
    }

    @Override
    public Set<Product> findByCategory(String category) {
        return productRepository.findAllByCategory(category);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public void updateProductName(long id, String name) {
        productRepository.updateProductName(id, name);
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }
}
