package com.example.SearchService.service;

import com.example.ProductService.model.Product;
import com.example.SearchService.repository.SearchRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SearchService {
    private final SearchRepository searchRepository;

    public SearchService(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    public CompletableFuture<List<Product>> search(String query){
        return searchRepository.searchProducts(query);
    }
}
