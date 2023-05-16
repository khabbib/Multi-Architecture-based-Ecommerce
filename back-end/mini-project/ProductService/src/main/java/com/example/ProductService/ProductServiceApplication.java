package com.example.ProductService;

import com.example.ProductService.model.Product;
import com.example.ProductService.repository.ProductRepository;
import com.example.util.FirebaseInitializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;
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
			FirebaseInitializer.initializeFireBase("product");
			//com.example.UserService.repository.createProduct(new Product(UUID.randomUUID().toString(), "Product 1", "Electronic", "Blue", "No condition", 100.00, 10));
			//com.example.UserService.repository.createProduct(new Product(UUID.randomUUID().toString(), "Product 2", "Electronic", "Black", "No condition", 99.00, 1));

			// Delete all products
			//com.example.UserService.repository.deleteAllProducts();

			// Get all products
			CompletableFuture<List<Product>> products = repository.getAllProducts();
			System.out.println("All products: " + products.get());

			// Get a product by ID
			CompletableFuture<Product> product = repository.getProductById("36f20b15-71a1-4679-8750-1e5b88d60dae");
			System.out.println("Product by ID: " + product.get());

			// Delete a product
			ResponseEntity<String> status = repository.deleteProduct("XXX");
			if(status.toString().contains("204")){
				System.out.println("Product not found" + status);
			}else {
				System.out.println("Product deleted successfully" + status );
			}
		};
	}

}
