package com.example.ProductService;

import com.example.ProductService.model.Product;
import com.example.ProductService.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner test(ProductRepository productRepository) {
		return (args) -> {


			// Create products

			String[] names = {
					"iPhone 12", "Samsung Galaxy S21", "Sony PlayStation 5",
					"Apple MacBook Pro", "DJI Mavic Air 2", "Bose QuietComfort 35 II",
					"Nintendo Switch", "GoPro Hero9 Black", "Amazon Echo Dot",
					"Fitbit Versa 3", "Nikon D850", "Canon EOS R6",
					"Microsoft Surface Pro 7", "LG OLED CX", "Sony WH-1000XM4",
					"Razer Blade 15", "Xbox Series X", "Google Pixel 5",
					"Tesla Model 3", "Sonos One", "HP Spectre x360",
			};
		//	for(int i = 0; i < names.length; i++){
		//		String pId = UUID.randomUUID().toString();
		//		String pName = names[i];
		//		String pType = generateRandomType();
		//		String pColor = generateRandomColor();
		//		String pCondition = generateRandomCondition();
		//		double pPrice = generateRandomPrice();
		//		double pQuantity = generateRandomQuantity();
		//		String pOwner = generateRandomOwner();
		//
		//		Product product = new Product(pId, pName, pType, pColor, pCondition, pPrice, pQuantity, pOwner);
		//		ResponseEntity<String> productCreated = productRepository.createProduct(product);
		//		System.out.println("Product created: " + productCreated);
		//
		//
		//	}


		};


	}

	public static String generateRandomType() {
		String[] types = {"Electronics", "Fashion", "Home Decor", "Appliances", "Sports"};
		Random random = new Random();
		int index = random.nextInt(types.length);
		return types[index];
	}

	public static String generateRandomColor() {
		String[] colors = {"Red", "Blue", "Green", "Yellow", "Black", "White"};
		Random random = new Random();
		int index = random.nextInt(colors.length);
		return colors[index];
	}

	public static String generateRandomCondition() {
		String[] conditions = {"New", "Used", "Refurbished"};
		Random random = new Random();
		int index = random.nextInt(conditions.length);
		return conditions[index];
	}

	public static double generateRandomPrice() {
		// Generate a random price between 10.0 and 1000.0
		Random random = new Random();
		return 10.0 + (990.0 * random.nextDouble());
	}

	public static double generateRandomQuantity() {
		// Generate a random quantity between 1.0 and 100.0
		Random random = new Random();
		return 1.0 + (99.0 * random.nextDouble());
	}

	public static String generateRandomOwner() {
		String[] owners = {"John Doe", "Jane Smith", "David Johnson", "Emily Davis", "Michael Wilson"};
		Random random = new Random();
		int index = random.nextInt(owners.length);
		return owners[index];
	}



}
