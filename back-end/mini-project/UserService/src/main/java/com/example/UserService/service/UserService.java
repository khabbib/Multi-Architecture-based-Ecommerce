package com.example.UserService.service;

import lombok.RequiredArgsConstructor;
import com.example.UserService.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.UserService.repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public CompletableFuture<List<User>> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public  CompletableFuture<User> getUserById(String id) throws ExecutionException, InterruptedException {
        return userRepository.getUserById(id);
    }

    public void createUser(User user) {
        String password = user.getPassword();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        user.setPassword(hashedPassword);
        userRepository.createUser(user);
    }

    public ResponseEntity<String> deleteUser(String id) {
        return userRepository.deleteUser(id);
    }

    public ResponseEntity<String> updateUser(String id, User user) {
        return userRepository.updateUser(id, user);
    }

    public String checkUserExists(String email, String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        for (User user : userRepository.getAllUsers().join()) {
            String hashedPassword = user.getPassword();
            System.out.println("Hashed password: " + hashedPassword + " Password: " + password);
            if (user.getEmail().equals(email) && passwordEncoder.matches(password, hashedPassword)) {
                return user.getId();
            }
        }

        return null;
    }
}
