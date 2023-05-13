package com.example.ProductService;

import com.example.ProductService.model.Product;
import com.example.ProductService.repository.ProductRepository;
import com.example.util.FirebaseInitializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	// This is a method that will run when the application starts.
	// It will add some data to the database.
	// This is just for testing purposes.
	@Bean
	public CommandLineRunner test(ProductRepository repository) {
		return (args) -> {
			FirebaseInitializer.initializeFireBase();
			repository.createProduct(new Product("Apple", 1.99, 10));
			repository.createProduct(new Product("Orange", 2.99, 20));

			// fetch all products
			repository.deleteProduct("-NVHx5Lu-e7WBZ2Rp3YY");
			System.out.println("Product deleted successfully");
		};
	}

}
