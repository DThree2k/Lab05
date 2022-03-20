package com.example.lab5a;

public class Product {
    private int id;
    private String title;
    private String shopName;
    private String price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Product(int id, String title, String shopName, String price) {
        this.id = id;
        this.title = title;
        this.shopName = shopName;
        this.price = price;
    }
}
