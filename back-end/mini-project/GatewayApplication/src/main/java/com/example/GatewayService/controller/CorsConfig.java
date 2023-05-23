package com.example.GatewayService.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class CorsConfig {
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList("http://localhost:5173")); // Set the allowed origin domain names
        configuration.setAllowedMethods(Collections.singletonList("*")); // Set the allowed HTTP methods (e.g., GET, POST, PUT, DELETE)
        configuration.setAllowCredentials(true); // Allow credentials (e.g., cookies, authorization headers)
        List<String> allowedHeaders = new ArrayList<>();
        allowedHeaders.add("Content-Type");
        allowedHeaders.add("Authorization");
        // Add more allowed headers as needed
        configuration.setAllowedHeaders(allowedHeaders);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public CorsWebFilter corsWebFilter() {
        return new CorsWebFilter(corsConfigurationSource());
    }

}
