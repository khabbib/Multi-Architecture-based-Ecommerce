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

    /**
     * Test if the service is up and running
     * @return
     */
    @GetMapping("/")
    public String test() {
        return "Authentication Service is up and running!";
    }

    /**
     * Authenticate the user
     * @param authRequest
     * @param response
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<List<HashMap<String, String>>>  login(@RequestBody AuthRequest authRequest, HttpServletResponse response) {
        System.out.println("Got request to login");
        String email = authRequest.getEmail();
        String password = authRequest.getPassword();
        ResponseEntity<List<HashMap<String, String>>> output = authService.login(email, password, response);
        System.out.println("Output from login: " + output);
        return output;
    }

    /**
     * Check if the user is authenticated
     * @param token
     * @return
     */
    @PostMapping("/check")
    public ResponseEntity<String> check(@RequestBody CheckAuthRequest token) {
        ResponseEntity<String> output = authService.check(token.getToken());
        return output;
    }

    /**
     * Logout the user
     * @param token
     * @param response
     * @return
     */
    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody CheckAuthRequest token, HttpServletResponse response) {
        System.out.println("Got request to logout: " + token.getToken());
        return authService.logout(token.getToken(), response);
    }

    /**
     * Get all online users
     * @return
     */
    @GetMapping("/online")
    public ResponseEntity<List<User>> getOnlineUsers() {
        System.out.println("Got request to get online users");
        return authService.getOnlineUsers();
    }
}
