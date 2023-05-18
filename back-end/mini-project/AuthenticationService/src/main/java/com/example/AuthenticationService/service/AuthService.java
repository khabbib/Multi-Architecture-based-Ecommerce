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

    public HashMap<String, String> login(String email, String password) {
        HashMap result = webClient.get()
                .uri("http://localhost:8084/users/user-exists?email=" + email + "&password=" + password)
                .retrieve()
                .bodyToMono(HashMap.class)
                .block();

        if (result != null) {
            return result;
        } else {
            return null;
        }
    }
}
