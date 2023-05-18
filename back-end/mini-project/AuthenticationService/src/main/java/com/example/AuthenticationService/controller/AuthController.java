package com.example.AuthenticationService.controller;

import com.example.AuthenticationService.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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
    public HashMap<String, String> login(@RequestBody HashMap<String, String> emailToPwd) {
        String email = emailToPwd.get("email");
        String password = emailToPwd.get("password");
        return authService.login(email, password);
    }
}