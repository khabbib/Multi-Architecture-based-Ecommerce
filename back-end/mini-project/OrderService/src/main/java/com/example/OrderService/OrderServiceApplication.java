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
			CompletableFuture<ResponseEntity<List<Order>>> customerFuture = repository.getOrdersByCustomerId("customer1");
			CompletableFuture<ArrayList<Order>> allOrdersFuture = repository.findAll();
			CompletableFuture<Order> orderFuture = repository.findById("e7665aaf-8d93-4a19-81c1-ecbe84a681b2");

			/*
			//create items list
			ArrayList<ItemList> items = new ArrayList<>();
			items.add(new ItemList("product1", 1, 10));
			items.add(new ItemList("product2", 2, 20));
			items.add(new ItemList("product3", 3, 30));
			// Create an order String customerId, ArrayList<ItemList> items, String shippingAddress, String billingAddress, String paymentMethod, String orderStatus, String orderDate, String deliveryDate, String deliveryCompany, String trackingNumber, String deliveryStatus, String deliveryAddress, double totalPriceTax);
			Order order1 = new Order("customer1", items, "shippingAddress", "billingAddress", "paymentMethod", "orderStatus", "orderDate", "deliveryDate", "deliveryCompany", "trackingNumber", "deliveryStatus", "deliveryAddress", 100);
			Order order2 = new Order("customer2", items, "shippingAddress", "billingAddress", "paymentMethod", "orderStatus", "orderDate", "deliveryDate", "deliveryCompany", "trackingNumber", "deliveryStatus", "deliveryAddress", 200);
			// Add the order to the database
			repository.save(order1);
			repository.save(order2);
			*/
			customerFuture.thenAccept(responseEntity -> {
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
			customerFuture.join(); // Wait for the CompletableFuture to complete


			allOrdersFuture.thenAccept(orders -> {
				// Handle the retrieved orders
				for (Order order : orders) {
					System.out.println("Retrieved Order: " + order);
				}
			}).exceptionally(ex -> {
				System.err.println("Error retrieving orders: " + ex.getMessage());
				return null;
			});

			orderFuture.thenAccept(order -> {
				// Handle the retrieved order
				System.out.println("Retrieved Order by id: " + order);
			}).exceptionally(ex -> {
				System.err.println("Error retrieving order: " + ex.getMessage());
				return null;
			});
		};
	}
}
