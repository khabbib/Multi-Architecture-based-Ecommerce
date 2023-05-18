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
        String result2 = webClient.get()
                .uri("http://localhost:8084/users/user-exists?email=" + emailToPwd.get("email") + "&password=" + emailToPwd.get("password"))
                .retrieve()
                .bodyToMono(String.class)
                .block();

        if (result2 != null) {
            return "User exists id: " + result2;
        } else {
            return "User does not exist";
        }
    }
}
