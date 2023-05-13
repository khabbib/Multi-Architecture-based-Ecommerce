package com.example.ProductService.controller;

import com.example.ProductService.model.Product;
import com.example.ProductService.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public  CompletableFuture<ResponseEntity<List<Product>>> getAvailableProducts() {
        return productService.getAllProducts().thenApply(product -> ResponseEntity.ok().body(product))
                .exceptionally(e -> ResponseEntity.notFound().build());
    }

    // Add product
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }

    // Get product by ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  CompletableFuture<ResponseEntity<Product>> getProductById(@PathVariable("id") String id) throws ExecutionException, InterruptedException {
        return productService.getProductById(id)
                .thenApply(product -> ResponseEntity.ok().body(product))
                .exceptionally(e -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteProduct(@RequestHeader String id) {
        return productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> updateProduct(@RequestHeader String id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

}
