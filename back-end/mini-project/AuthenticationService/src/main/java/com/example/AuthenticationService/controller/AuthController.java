package com.example.AuthenticationService.controller;

import com.example.AuthenticationService.dto.AuthRequest;
import com.example.AuthenticationService.dto.CheckAuthRequest;
import com.example.AuthenticationService.service.AuthService;
import com.example.UserService.model.User;
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
    public ResponseEntity<String> check(@RequestBody CheckAuthRequest token) {
        System.out.println("Got request to check" + token.getToken());
        ResponseEntity<String> output = authService.check(token.getToken());
        System.out.println("Output from check: " + output);
        return output;
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody CheckAuthRequest token, HttpServletResponse response) {
        System.out.println("Got request to logout: " + token.getToken());
        return authService.logout(token.getToken(), response);
    }

    @GetMapping("/online")
    public ResponseEntity<List<User>> getOnlineUsers() {
        System.out.println("Got request to get online users");
        return authService.getOnlineUsers();
    }
}
