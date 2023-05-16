package com.example.OrderService;

import com.example.OrderService.model.ItemList;
import com.example.OrderService.model.Order;
import com.example.OrderService.repository.OrderRepository;
import com.example.util.FirebaseInitializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.UUID;

@SpringBootApplication
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
			ArrayList<ItemList> itemArray = new ArrayList<>();
			itemArray.add(new ItemList("item1", 1, 1.99));
			itemArray.add(new ItemList("item2", 2, 2.99));
			itemArray.add(new ItemList("item3", 3, 3.99));

			repository.save(new Order(UUID.randomUUID().toString(), itemArray, "123 Main St", "12345", "PayPal", "Pendding", "2021-01-01", "2021-01-01", "PostNord", "1234567890", "Pendding", "Lund", 12345));
			repository.save(new Order(UUID.randomUUID().toString(), itemArray, "None", "None", "Swish", "Created", "2021-01-29", "2021-02-01", "PostNord", "1234567891", "On the way", "Malmö", 10000));
			// fetch all orders
			System.out.println("Find all orders:");
			for (Order order : repository.findAll()) {
				System.out.println(order);
			}
		};
	}
}
