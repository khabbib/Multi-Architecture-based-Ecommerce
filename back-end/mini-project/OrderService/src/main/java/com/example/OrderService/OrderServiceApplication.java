package com.example.OrderService;

import com.example.OrderService.model.ItemList;
import com.example.OrderService.model.Order;
import com.example.OrderService.repository.OrderRepository;
import com.example.util.FirebaseInitializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	// This is a method that will run when the application starts.
	// It will add some data to the database.
	// This is just for testing purposes.
	@Bean
	public CommandLineRunner test(OrderRepository repository) {
		return (args) -> {
			// Create an
			FirebaseInitializer.initializeFireBase("order");
			CompletableFuture<ResponseEntity<List<Order>>> future = repository.getOrdersByCustomerId("d031b00f-322e-4518-aafe-47f7caf715a9");

			future.thenAccept(responseEntity -> {
				if (responseEntity.getStatusCode().is2xxSuccessful()) {
					List<Order> orders = responseEntity.getBody();
					// Handle the retrieved orders
					for (Order order : orders) {
						System.out.println("Order: " + order);
					}
				} else {
					System.err.println("Error retrieving orders: " + responseEntity.getStatusCode());
				}
			}).exceptionally(ex -> {
				System.err.println("Error retrieving orders: " + ex.getMessage());
				return null;
			});

			future.join(); // Wait for the CompletableFuture to complete
		};
	}
}
