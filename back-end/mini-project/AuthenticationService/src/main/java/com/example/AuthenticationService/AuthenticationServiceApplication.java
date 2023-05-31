package com.example.AuthenticationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * The Authentication service application.
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableDiscoveryClient
public class AuthenticationServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServiceApplication.class, args);
	}
}
