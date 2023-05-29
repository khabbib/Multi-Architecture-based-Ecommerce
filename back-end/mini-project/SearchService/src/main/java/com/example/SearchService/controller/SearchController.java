package com.example.SearchService.controller;

import com.example.SearchService.service.SearchService;
import com.example.ProductService.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Controller for search.
 */
@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    /**
     * Searches for products that start with the query.
     * @param query The search query.
     * @return A list of products that match the query.
     */

    @GetMapping("/{query}")
    public CompletableFuture<ResponseEntity<List<Product>>> search(@PathVariable String query) {
        CompletableFuture<List<Product>> searchFuture = searchService.search(query);
        List<Product> searchResults;
        try {
            searchResults = searchFuture.get(); // Wait for the CompletableFuture to complete and get the results.
            // Process the searchResults as needed.
            System.out.println("SearchControll: " + searchResults);
        } catch (InterruptedException | ExecutionException e) {
            // Handle any exceptions that occurred while retrieving the results.
            e.printStackTrace();
        }

        return searchService.search(query)
                .thenApply(product -> ResponseEntity.ok().body(product))
                .exceptionally(e -> ResponseEntity.notFound().build());
    }


    @GetMapping("/")
    public String init() {
        return "Hello from search!";
    }
}
