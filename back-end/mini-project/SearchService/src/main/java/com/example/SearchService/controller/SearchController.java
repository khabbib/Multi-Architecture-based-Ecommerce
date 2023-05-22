package com.example.SearchService.controller;

import com.example.SearchService.service.SearchService;
import com.example.ProductService.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.List;

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
        return searchService.search(query)
                .thenApply(products -> ResponseEntity.ok().body(products))
                .exceptionally(e -> ResponseEntity.notFound().build());
    }


    @GetMapping("/")
    public String init() {
        return "Hello from search!";
    }
}
