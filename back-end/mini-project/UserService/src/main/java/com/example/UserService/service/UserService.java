package com.example.UserService.service;

import lombok.RequiredArgsConstructor;
import com.example.UserService.model.User;
import org.springframework.http.ResponseEntity;
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
        userRepository.createUser(user);
    }

    public ResponseEntity<String> deleteUser(String id) {
        return userRepository.deleteUser(id);
    }

    public ResponseEntity<String> updateUser(String id, User user) {
        return userRepository.updateUser(id, user);
    }

    public String checkUserExists(String email, String password) {
        System.out.println("[UserService] Email: " + email + " Password: " + password);

        for (User user : userRepository.getAllUsers().join()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user.getId();
            }
        }

        return null;
    }
}
