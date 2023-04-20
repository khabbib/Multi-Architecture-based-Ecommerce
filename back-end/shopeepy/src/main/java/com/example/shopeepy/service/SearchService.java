package com.example.shopeepy.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    public List<String> search(String query) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Search result for " + query);
        return list;
    }
}
