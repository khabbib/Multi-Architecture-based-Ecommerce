package com.example.shopeepy.api;

import com.example.shopeepy.api.auth.LoginController;
import com.example.shopeepy.api.product.ProductController;
import com.example.shopeepy.api.search.SearchController;
import com.example.shopeepy.api.user.UserController;
import com.example.shopeepy.service.FireBaseInitializer;
import com.example.shopeepy.model.Person;
import com.example.shopeepy.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class MainController {

    @Autowired
    private FireBaseInitializer firebase;
    private UserController userC;
    private ProductController productC;
    private LoginController loginC;
    private SearchController searchC;

    public MainController() {
        userC = new UserController();
        productC = new ProductController();
        loginC = new LoginController();
        searchC = new SearchController();
    }


    @GetMapping("get/{resource}/{id}")
    public Object getResourceById(@PathVariable String resource, @PathVariable Long id) {
        switch (resource) {
            case "users":
                return userC.getUserById(id);
            case "products":
                return productC.getProductById(id);

                // TODO: Add more resources like search and login
            default:
                throw new IllegalArgumentException("Invalid resource");
        }
    }

    @GetMapping("get/{resource}")
    public Object getResource(@PathVariable String resource) {
        switch (resource) {
            case "users":
                return userC.getActiveUsers();
            case "products":
                return productC.getAvailableProducts();

            default:
                throw new IllegalArgumentException("Invalid resource");
        }
    }

    @PostMapping("{resource}")
    public Object addResource(@PathVariable String resource, @RequestBody Object object) throws Exception {
        System.out.println("Adding resource: " + resource);
        switch (resource) {
            case "users":
                return userC.createUser((Person) object);
            case "products":
                return productC.createProduct((Product) object);
            default:
                throw new IllegalArgumentException("Invalid resource");
        }
    }

    @GetMapping("/search/{query}")
    public Object search(@PathVariable String query) {
        System.out.println("Searching for: " + query);
        searchC.search(query);
        return "Search results";
    }


}
