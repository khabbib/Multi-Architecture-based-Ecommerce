package com.example.ProductService.controller;

import com.example.ProductService.model.Product;
import com.example.ProductService.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Controller for products.
 */
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    /**
     * Returns all products.
     * @return ResponseEntity<List<Product>>
     */
    
    @GetMapping("/")
    public  CompletableFuture<ResponseEntity<List<Product>>> getAvailableProducts() {
        return productService.getAllProducts().thenApply(product -> ResponseEntity.ok().body(product))
                .exceptionally(e -> ResponseEntity.notFound().build());
    }


    /**
     * Creates product.
     * @param product
     * @return ResponseEntity<String>
     */
    @PostMapping("/create")
    public void createProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }

    /**
     * Returns product based on ID.
     * @param id
     * @return ResponseEntity<Product>
     */
    @GetMapping("/{id}")
    public  CompletableFuture<ResponseEntity<Product>> getProductById(@PathVariable("id") String id) throws ExecutionException, InterruptedException {
        return productService.getProductById(id)
                .thenApply(product -> ResponseEntity.ok().body(product))
                .exceptionally(e -> ResponseEntity.notFound().build());
    }

    /**
     * Deletes a product based on ID.
     * @param id
     * @return ResponseEntity<String>
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@RequestHeader String id) {
        return productService.deleteProduct(id);
    }

    /**
     * Updates a product based on ID.
     * @param id
     * @param product
     * @return ResponseEntity<String>
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@RequestHeader String id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

}
