package com.example.shopeepy.api.user;

import com.example.shopeepy.model.Person;
import com.example.shopeepy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService = new UserService();

    @GetMapping("/")
    public List<Person> getActiveUsers() {
        return  userService.getActiveUsers();
    }

    @GetMapping("/{id}")
    public Person getUserById(@RequestHeader() String id) {
        return userService.getUserById(id);
    }

    @PostMapping("/add")
    public String createUser(@RequestBody Person person) throws Exception {
        System.out.println("createuser");
        userService.createUser(person);
        return "Created User ";
    }

    @PutMapping("/{id}")
    public String updateUser(@RequestBody Person person) {
        return "Updated User";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@RequestHeader Long id) {
        return "Deleted User ";
    }

}
