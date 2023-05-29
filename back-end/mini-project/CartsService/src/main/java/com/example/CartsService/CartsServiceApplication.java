package com.example.CartsService;

import com.example.CartsService.model.Cart;
import com.example.CartsService.repository.CartRepository;
import com.example.util.FirebaseInitializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@SpringBootApplication
@EnableDiscoveryClient
public class CartsServiceApplication {
    public static void main(String[] args) {SpringApplication.run(CartsServiceApplication.class, args);}


        @Bean
        public CommandLineRunner test(CartRepository cartRepository) {
            return (args) -> {
                FirebaseInitializer.initializeFireBase("cart");
                // Search carts

                /*
                HashMap<String, String> values = new HashMap<>();
                values.put("1", "1");
                values.put("2", "2");
                values.put("3", "3");
                cartRepository.createNewCart(new Cart(3.0,3.0,3.0, values));

                 */

                CompletableFuture<List<Cart>> carts = cartRepository.getAvailableCarts();
                System.out.println("All carts: " + carts.get());
            };
    }
}
