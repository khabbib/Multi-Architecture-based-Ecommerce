package com.example.ProductService.service;

import com.example.ProductService.model.Product;
import com.example.ProductService.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public CompletableFuture<List<Product>> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public  CompletableFuture<Product> getProductById(String id) throws ExecutionException, InterruptedException {
        return productRepository.getProductById(id);
    }

    public void createProduct(Product product) {
        productRepository.createProduct(product);
    }
}
