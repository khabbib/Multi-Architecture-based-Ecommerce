package controller;

import lombok.RequiredArgsConstructor;
import model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Controller for users.
 */
@RestController
@RequestMapping("/Users")
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
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
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

}
