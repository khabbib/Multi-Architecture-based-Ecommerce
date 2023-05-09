package com.example.shopeepy.api.user;

import com.example.shopeepy.model.User;
import com.example.shopeepy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Controller for Users.
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * Returns all users.
     *
     * @return ResponseEntity<List < User>>
     */
    @GetMapping("/")
    public CompletableFuture<ResponseEntity<List<User>>> getAvailableusers() {
        return userService.getAllUsers().thenApply(user -> ResponseEntity.ok().body(user)).exceptionally(e -> ResponseEntity.notFound().build());
    }

    /**
     * Returns user based on ID.
     *
     * @param id
     * @return ResponseEntity<user>
     */
    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<User>> getuserById(@PathVariable String id) {
        return userService.getUserById(id).thenApply(user -> ResponseEntity.ok().body(user)).exceptionally(e -> ResponseEntity.notFound().build());
    }

    /**
     * Creates user.
     *
     * @param user
     * @return ResponseEntity<String>
     */
    @PostMapping("/create")
    public ResponseEntity<String> createuser(@RequestBody User user) {
        return userService.createUser(user);
    }

    /**
     * Updates a user based on ID.
     *
     * @param id
     * @param user
     * @return ResponseEntity<String>
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateuser(@PathVariable String id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    /**
     * Deletes a user based on ID.
     *
     * @param id
     * @return ResponseEntity<String>
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteuser(@PathVariable String id) {
        return userService.deleteUser(id);
    }
}

