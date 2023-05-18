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
    public String login(@RequestBody HashMap<String, String> emailToPwd) {
        System.out.println("Received emailToPwd in AuthController: " + emailToPwd);
        return authService.login(emailToPwd);
    }
}
