package com.example.shopeepy.api.product;

import com.example.shopeepy.model.Person;
import com.example.shopeepy.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private Product product;

    @GetMapping("/")
    public Person getAvailableProducts() {
        ArrayList availableProducts = product.getAvailableProducts();
        return null;
    }

    @GetMapping("/{id}")
    public Person getProductById(@RequestHeader() Long id) {
        return null;
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
