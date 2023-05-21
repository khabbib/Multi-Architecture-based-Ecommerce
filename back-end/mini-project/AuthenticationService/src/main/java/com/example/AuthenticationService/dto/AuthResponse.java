package com.example.AuthenticationService.dto;

public class AuthResponse {
    private int statusCode;
    private String message;
    private String token;

    public AuthResponse() {
    }


    public AuthResponse(int statusCode, String message, String token) {
        this.statusCode = statusCode;
        this.message = message;
        this.token = token;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    @Override
    public String toString() {
        return "AuthResponse{" + "statusCode=" + statusCode + ", message=" + message + ", token=" + token + '}';
    }
}
