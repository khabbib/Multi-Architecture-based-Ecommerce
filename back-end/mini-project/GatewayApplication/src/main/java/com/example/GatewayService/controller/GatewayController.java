package com.example.GatewayService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {

    @GetMapping("/")
    public String hello() {
        return "Hello from Gateway!";
    }




}
