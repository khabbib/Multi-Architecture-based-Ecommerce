package com.example.ProductService.model;

public class Product {
    private String pId;
    private String pName;
    private String pType;
    private String pColor;
    private String pCondition;
    private double pPrice;
    private double pQuantity;


    public Product(String pId, String name, String type, String pColor, String pCondition, double pPrice, double pQuantity) {
        this.pId = pId;
        this.pName = name;
        this.pType = type;
        this.pColor = pColor;
        this.pCondition = pCondition;
        this.pPrice = pPrice;
        this.pQuantity = pQuantity;
    }



    public Product() {
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
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

    public double getpPrice() {
        return pPrice;
    }

    public void setpPrice(Long pPrice) {
        this.pPrice = pPrice;
    }

    public double getpQuantity() {
        return pQuantity;
    }

    public void setpQuantity(Long pQuantity) {
        this.pQuantity = pQuantity;
    }


    @Override
    public String toString() {
        return "Product{" +
                "pId='" + pId + '\'' +
                ", pName='" + pName + '\'' +
                ", pType='" + pType + '\'' +
                ", pColor='" + pColor + '\'' +
                ", pCondition='" + pCondition + '\'' +
                ", pPrice='" + pPrice + '\'' +
                ", pQuantity='" + pQuantity + '\'' +
                '}';
    }

}