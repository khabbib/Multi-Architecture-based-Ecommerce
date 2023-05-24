package com.example.AuthenticationService.service;

import com.example.AuthenticationService.dto.AuthResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private final WebClient.Builder webClientBuilder;
    private List<AuthResponse> authResponse = new ArrayList<>();

    public ResponseEntity<List<HashMap<String, String>>> login(String email, String password, HttpServletResponse response) {
        HashMap result = webClientBuilder.build().get()
                .uri("http://localhost:2020/users/user-exists?email=" + email + "&password=" + password)
                .retrieve()
                .bodyToMono(HashMap.class)
                .block();

        // Control the response
        System.out.println("Result from user-service: " + result);
        if (result != null) {
            String issuer = (String) result.get("id");
            // expireation time for 20 seconds
            long expirationTime = 20000;
            String secretKey = "secret";
            String jwt = Jwts.builder()
                    .setSubject(issuer)
                    .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                    .signWith(SignatureAlgorithm.HS512, secretKey)
                    .compact();

            Cookie cookie = new Cookie("jwt", jwt);
            response.addCookie(cookie);
            cookie.setHttpOnly(true);
            cookie.setDomain("localhost:5173");
            AuthResponse user = new AuthResponse(expirationTime, issuer, jwt);
            authResponse.add(user);
            // Send the cookies through the response body
            return ResponseEntity.ok().body(List.of(new HashMap<>(Map.of("cookie", jwt))));
        } else {
            return ResponseEntity.badRequest().body(List.of(new HashMap<>()));
        }
    }

    public ResponseEntity<String> check(String token) {
        AuthResponse AuthResponse = authResponse.stream().filter(authResponse -> authResponse.getToken().equals(token)).findFirst().orElse(null);
        if (AuthResponse != null) {
            return ResponseEntity.ok("User is logged in");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User is not logged in");
        }
    }

    public ResponseEntity<String> logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("jwt", "");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return ResponseEntity.ok("User logged out");
    }
}
