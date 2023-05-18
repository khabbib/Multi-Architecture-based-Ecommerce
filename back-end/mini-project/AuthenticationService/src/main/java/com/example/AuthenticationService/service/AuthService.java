package com.example.AuthenticationService.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private final WebClient webClient;

    public String login(HashMap<String, String> emailToPwd) {
        System.out.println("Check: " + emailToPwd);

        String result = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("http")
                        .host("localhost")
                        .port(8084)
                        .path("/users/user-exists")
                        .queryParam("email", emailToPwd.get("email"))
                        .queryParam("password", emailToPwd.get("password"))
                        .build()).retrieve().bodyToMono(String.class).block();

        if (result != null) {
            return "User exists";
        } else {
            return "User does not exist";
        }
    }
}
