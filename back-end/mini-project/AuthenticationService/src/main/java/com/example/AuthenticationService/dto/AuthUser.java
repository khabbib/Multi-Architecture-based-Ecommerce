package com.example.AuthenticationService.dto;

import java.util.Date;

public class AuthResponse {
    private Date expireTime;
    private String user;
    private String token;

    public AuthResponse() {
    }


    public AuthResponse(Date expireTime, String user, String token) {
        this.expireTime = expireTime;
        this.user = user;
        this.token = token;
    }


    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    @Override
    public String toString() {
        return "AuthResponse{" +
                "expireTime='" + expireTime + '\'' +
                ", user='" + user + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
