package com.example.shopeepy.api.user;

import com.example.shopeepy.model.person.Person;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.ExecutionException;

@RestController
public class User {
    private Person person = new Person();



    @GetMapping("/getActiveUsers")
    public Person getActiveUsers() {
        return person.getActiveUsers();
    }




    @GetMapping("/getUser")
    public Person getUser(@RequestHeader() String id) {
        return null;
    }

    @PostMapping("/createUser")
    public String createUser(@RequestBody Person person) {
        return "Created User ";
    }

    @PutMapping("/updateUser")
    public String updateUser(@RequestBody Person person) {
        return "Updated User";
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestHeader String name) {
        return "Deleted User ";
    }

}
