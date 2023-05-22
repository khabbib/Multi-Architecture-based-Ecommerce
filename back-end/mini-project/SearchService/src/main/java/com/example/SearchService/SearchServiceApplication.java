package com.example.SearchService;

import com.example.ProductService.model.Product;
import com.example.ProductService.repository.ProductRepository;
import com.example.SearchService.repository.SearchRepository;
import com.example.util.FirebaseInitializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@SpringBootApplication
@EnableDiscoveryClient
public class SearchServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SearchServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner test(SearchRepository repository) {
        return (args) -> {
            FirebaseInitializer.initializeFireBase("product");
            // Search products
            CompletableFuture<List<Product>> products = repository.searchProducts("Product 1");
            if(products.get().isEmpty())
                System.out.println("NOT FOUND");
            else
                for(Product product : products.get())
                    System.out.println("FOUND: " + product);
        };
    }
}
