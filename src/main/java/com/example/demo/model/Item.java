package com.example.demo.model;

import lombok.Data;

@Data
public class Item {
    public String name;
    public String description;
    public int stock;
    public boolean onSale;
    public int price;

    public Item(String name, String description, int stock, boolean onSale, int price) {
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.onSale = onSale;
        this.price = price;
    }
}

