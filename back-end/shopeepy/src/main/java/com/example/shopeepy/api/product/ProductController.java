package com.example.shopeepy.api.product;

import com.example.shopeepy.model.Person;
import com.example.shopeepy.model.Product;
import com.example.shopeepy.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public CompletableFuture<ResponseEntity<List<Product>>> getAvailableProducts() {
        return productService.getAllProducts().thenApply(product -> ResponseEntity.ok().body(product)).exceptionally(e -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<Product>> getProductById(@PathVariable Long id) {
        return productService.getProductById(id).thenApply(product -> ResponseEntity.ok().body(product)).exceptionally(e -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable String id, @RequestBody Product product) {
       return productService.updateProduct(id, product);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        return productService.deleteProduct(id);
    }
}
