package com.example.AuthenticationService.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Date;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private final WebClient.Builder webClientBuilder;

    public ResponseEntity<String> login(String email, String password, HttpServletResponse response) {
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

            System.out.println("Issuer: " + issuer);
            String secretKey = "secret";
            String jwt = Jwts.builder()
                    .setSubject(issuer)
                    .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                    .signWith(SignatureAlgorithm.HS512, secretKey)
                    .compact();

            Cookie cookie = new Cookie("jwt", jwt);
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
            return ResponseEntity.ok("User authorized");
        } else {
            return ResponseEntity.badRequest().body("User not authorized");
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
