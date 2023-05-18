package com.example.UserService;

import com.example.UserService.model.User;
import com.example.UserService.repository.UserRepository;
import com.example.util.FirebaseInitializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;


@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	// This is a method that will run when the application starts.
	// It will add some data to the database.
	// This is just for testing purposes.
	@Bean
	public CommandLineRunner test(UserRepository repository) {
		return (args) -> {
			FirebaseInitializer.initializeFireBase("user");
			//repository.createUser(new User(UUID.randomUUID().toString(), "User 1", "XOUSER", "pwd", "Admin"));
			//repository.createUser(new User(UUID.randomUUID().toString(), "User 2", "XOUSER", "pwd", "User"));

			// Get all users
			CompletableFuture<List<User>> users = repository.getAllUsers();
			System.out.println("All users: " + users.get());
		};
	}

}
