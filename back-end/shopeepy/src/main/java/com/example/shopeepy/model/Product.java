package com.example.shopeepy.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Product {

    private String pName;
    private String pType;
    private String pColor;
    private String pCondition;
    private Long pPrice;

    public Product(String name, String type, String pColor, String pCondition, Long pPrice) {
        this.pName = name;
        this.pType = type;
        this.pColor = pColor;
        this.pCondition = pCondition;
        this.pPrice = pPrice;
    }

    public Product() {
    }

    public ArrayList getAvailableProducts() {
        return null;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }

    public String getpColor() {
        return pColor;
    }

    public void setpColor(String pColor) {
        this.pColor = pColor;
    }

    public String getpCondition() {
        return pCondition;
    }

    public void setpCondition(String pCondition) {
        this.pCondition = pCondition;
    }

    public Long getpPrice() {
        return pPrice;
    }

    public void setpPrice(Long pPrice) {
        this.pPrice = pPrice;
    }
}