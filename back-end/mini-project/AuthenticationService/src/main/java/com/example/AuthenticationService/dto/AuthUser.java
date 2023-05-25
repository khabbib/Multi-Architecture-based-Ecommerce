package com.example.AuthenticationService.dto;

import com.example.UserService.model.User;

import java.util.Date;

public class AuthUser {
    private Date expireTime;
    private User user;
    private String token;

    public AuthUser() {
    }


    public AuthUser(Date expireTime, User user, String token) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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
        return "AuthUser{" +
                "expireTime='" + expireTime + '\'' +
                ", user='" + user + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
