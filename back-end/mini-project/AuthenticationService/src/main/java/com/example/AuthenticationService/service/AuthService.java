package com.example.AuthenticationService.service;

import com.example.AuthenticationService.dto.AuthRequest;
import com.example.AuthenticationService.dto.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.HashMap;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private final WebClient.Builder webClientBuilder;

    public ResponseEntity<AuthResponse> login(String email, String password) {
        HashMap result = webClientBuilder.build().get()
                .uri("http://userservice/users/user-exists?email=" + email + "&password=" + password)
                .retrieve()
                .bodyToMono(HashMap.class)
                .block();

        // Control the response
        if (result != null) {
            AuthResponse authResponse = new AuthResponse(200, "User authorized", UUID.randomUUID().toString());
            return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.OK);
        } else {
            AuthResponse authResponse = new AuthResponse(401, "User not authorized", null);
            return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.UNAUTHORIZED);
        }
    }
}
