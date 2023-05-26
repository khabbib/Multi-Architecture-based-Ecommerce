package com.example.AuthenticationService.dto;

public class CheckAuthRequest {
    private String token;

    public CheckAuthRequest() {
    }

    public CheckAuthRequest(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
