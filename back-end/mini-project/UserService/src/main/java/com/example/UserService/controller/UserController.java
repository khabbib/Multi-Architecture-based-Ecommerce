package com.example.UserService.controller;

import lombok.RequiredArgsConstructor;
import com.example.UserService.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.UserService.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Controller for users.
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    /**
     * Returns all users.
     * @return ResponseEntity<List<User>>
     */
    @GetMapping("/")
    public CompletableFuture<ResponseEntity<List<User>>> getAvailableUsers() {
        return userService.getAllUsers().thenApply(product -> ResponseEntity.ok().body(product))
                .exceptionally(e -> ResponseEntity.notFound().build());
    }

    /**
     * Creates user.
     * @param user
     * @return ResponseEntity<String>
     */
    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        ResponseEntity<String> res = userService.createUser(user);
        System.out.println("Check: " + res);
        return res;
    }

    /**
     * Returns user based on ID.
     * @param id
     * @return ResponseEntity<User>
     */
    @GetMapping("/{id}")
    public  CompletableFuture<ResponseEntity<User>> getUserById(@PathVariable("id") String id) throws ExecutionException, InterruptedException {
        return userService.getUserById(id)
                .thenApply(product -> ResponseEntity.ok().body(product))
                .exceptionally(e -> ResponseEntity.notFound().build());
    }

    /**
     * Deletes a user based on ID.
     * @param id
     * @return ResponseEntity<String>
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@RequestHeader String id) {
        return userService.deleteUser(id);
    }

    /**
     * Updates a user based on ID.
     * @param id
     * @param user
     * @return ResponseEntity<String>
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@RequestHeader String id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    /**
     * Check for the user existance.
     * @param email
     * @param password
     * @return ResponseEntity<String>
     */
    @GetMapping("/user-exists")
    @ResponseStatus(HttpStatus.OK)
    public User checkUserExists(@RequestParam String email, @RequestParam String password) throws ExecutionException, InterruptedException {
        User response = userService.checkUserExists(email, password);
        return response;
    }
}
