package com.example.shopeepy.api.search;

import com.example.shopeepy.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.directory.SearchResult;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService = new SearchService();



    @GetMapping
    public List<SearchResult> search(@RequestParam("q") String query) {
        return searchService.search(query);
    }
}
