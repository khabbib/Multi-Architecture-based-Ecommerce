package com.example.GatewayService.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import java.util.Collections;


@Configuration
public class CorsConfig extends org.springframework.web.cors.CorsConfiguration{

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(false);
        configuration.setAllowedOrigins(Collections.singletonList("*")); //Eller ändra denna till localhost
        configuration.setAllowedMethods(Collections.singletonList("*"));
        configuration.setAllowedHeaders(Collections.singletonList("content-type"));
        CorsConfigurationSource source = exchange -> configuration;

        return new CorsWebFilter(source);
    }
}
