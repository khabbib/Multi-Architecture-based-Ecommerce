package com.example.shopeepy.api.product;

import com.example.shopeepy.model.Person;
import com.example.shopeepy.model.Product;
import com.example.shopeepy.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private Product product;
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public Person getAvailableProducts() {
        ArrayList availableProducts = product.getAvailableProducts();
        return null;
    }

    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<Product>> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .thenApply(product -> ResponseEntity.ok().body(product))
                .exceptionally(e -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public String createProduct(@RequestBody Product product) {
        return "Created product";
    }

    @PutMapping("/{id}")
    public String updateProduct(@RequestBody Product product) {
        return "Updated product";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@RequestHeader Long id) {
        return "Deleted product ";
    }
}
