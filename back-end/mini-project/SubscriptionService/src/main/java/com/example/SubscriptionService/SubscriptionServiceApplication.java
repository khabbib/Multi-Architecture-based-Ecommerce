package com.example.SubscriptionService;

import com.example.SubscriptionService.model.Subscription;
import com.example.SubscriptionService.repository.SubscriptionRepository;
import com.example.util.FirebaseInitializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@SpringBootApplication
@EnableDiscoveryClient
public class SubscriptionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscriptionServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner test(SubscriptionRepository repository) {
		System.out.println("======== TEST ========");
		return args -> {
			FirebaseInitializer.initializeFireBase("subscription");


			// Generate a new ID for testing
			String testId = generateId();

			// Testing createSubscription()
			Subscription newSubscription = new Subscription();
			List<String> newSubscriptions = Arrays.asList("Subscription 1", "Subscription 2", "Subscription 3");
			newSubscription.setSubscriptions(newSubscriptions);
			ResponseEntity<String> createResponse = repository.createSubscription(newSubscription, testId);
			System.out.println(createResponse.getBody());


			// Testing getSubscriptionById()
			CompletableFuture<Subscription> getByIdFuture = repository.getSubscriptionById(testId);
			getByIdFuture.thenAccept(subscription -> {
				if (subscription != null) {
					System.out.println("Subscription found:");
					for (int i = 0; i < subscription.getSubscriptions().size(); i++) {
						System.out.println(i + ". " + subscription.getSubscriptions().get(i));
					}
				} else {
					System.out.println("Subscription not found");
				}
			});

			// Testing getAllSubscriptions()
			CompletableFuture<List<Subscription>> getAllFuture = repository.getAllSubscriptions();
			getAllFuture.thenAccept(subscriptions -> {
				System.out.println("All Subscriptions:");
				for (Subscription subscription : subscriptions) {
					System.out.println(subscription.getId() + ":");
					for (int i = 0; i < subscription.getSubscriptions().size(); i++) {
						System.out.println(i + ". " + subscription.getSubscriptions().get(i));
					}
				}
			});

			// Testing deleteSubscription()
			ResponseEntity<String> deleteResponse = repository.deleteSubscription(testId);
			System.out.println(deleteResponse.getBody());

			System.out.println("======== TEST OVER ========");
		};
	}

	private String generateId() {
		// Generate a random UUID as the ID
		return UUID.randomUUID().toString();
	}

}
