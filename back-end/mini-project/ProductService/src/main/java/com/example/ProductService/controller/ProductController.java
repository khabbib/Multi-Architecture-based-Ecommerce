package com.example.ProductService.controller;

import com.example.ProductService.model.Product;
import com.example.ProductService.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    // Get all products
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public  CompletableFuture<List<Product>> getAvailableProducts() {
        CompletableFuture<List<Product>> products = productService.getAllProducts();
        return products;
    }

    // Add product
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return product.toString();
    }

    // Get product by ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  CompletableFuture<Product> getProductById(@PathVariable("id") String id) throws ExecutionException, InterruptedException {
        CompletableFuture<Product> product = productService.getProductById(id);
        return product;
    }

}
