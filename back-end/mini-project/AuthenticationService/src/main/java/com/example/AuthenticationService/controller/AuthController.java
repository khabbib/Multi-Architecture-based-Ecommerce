package com.example.AuthenticationService.controller;

import com.example.AuthenticationService.dto.AuthRequest;
import com.example.AuthenticationService.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private AuthService authService;

    @GetMapping("/")
    public String test() {
        return "Authentication Service is up and running!";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest, HttpServletResponse response) {
        System.out.println("Got request to login");
        String email = authRequest.getEmail();
        String password = authRequest.getPassword();
        return authService.login(email, password, response);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletResponse response) {
        System.out.println("Got request to logout");
        return authService.logout(response);
    }
}
