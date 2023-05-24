package com.example.AuthenticationService.controller;

import com.example.AuthenticationService.dto.AuthRequest;
import com.example.AuthenticationService.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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
    public ResponseEntity<List<HashMap<String, String>>>  login(@RequestBody AuthRequest authRequest, HttpServletResponse response) {
        System.out.println("Got request to login");
        String email = authRequest.getEmail();
        String password = authRequest.getPassword();
        ResponseEntity<List<HashMap<String, String>>> output = authService.login(email, password, response);
        System.out.println("Output from login: " + output);
        return output;
    }

    @PostMapping("/check")
    public ResponseEntity<String> check(@RequestBody String token) {
        System.out.println("Got request to check" + token);
        return authService.check(token);
    }


    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletResponse response) {
        System.out.println("Got request to logout");
        return authService.logout(response);
    }
}
