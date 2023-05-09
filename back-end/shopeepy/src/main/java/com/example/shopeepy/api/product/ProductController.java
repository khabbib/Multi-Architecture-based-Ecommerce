package com.example.shopeepy.api.product;

import com.example.shopeepy.model.Product;
import com.example.shopeepy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Controller for products.
 */
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * Returns all products.
     * @return ResponseEntity<List<Product>>
     */
    @GetMapping("/")
    public CompletableFuture<ResponseEntity<List<Product>>> getAvailableProducts() {
        return productService.getAllProducts().thenApply(product -> ResponseEntity.ok().body(product)).exceptionally(e -> ResponseEntity.notFound().build());
    }

    /**
     * Returns product based on ID.
     * @param id
     * @return ResponseEntity<Product>
     */
    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<Product>> getProductById(@PathVariable Long id) {
        return productService.getProductById(id).thenApply(product -> ResponseEntity.ok().body(product)).exceptionally(e -> ResponseEntity.notFound().build());
    }

    /**
     * Creates product.
     * @param product
     * @return ResponseEntity<String>
     */
    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    /**
     * Updates a product based on ID.
     * @param id
     * @param product
     * @return ResponseEntity<String>
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable String id, @RequestBody Product product) {
       return productService.updateProduct(id, product);
    }

    /**
     * Deletes a product based on ID.
     * @param id
     * @return ResponseEntity<String>
     */
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        return productService.deleteProduct(id);
    }
}
