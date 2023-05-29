package com.example.SearchService.service;

import com.example.ProductService.model.Product;
import com.example.SearchService.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final SearchRepository searchRepository;

    public CompletableFuture<List<Product>> search(String query){
        return searchRepository.searchProducts(query);
    }
}
