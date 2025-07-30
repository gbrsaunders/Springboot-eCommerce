package com.example.demo.model;

import lombok.Data;

@Data
public class Item {
    public static int total = 0;
    public int ID;
    public String name;
    public String description;
    public int stock;
    public boolean onSale;
    public int price;
    public String image;

    public Item(String name, String description, int stock, int price) {
        this.ID = total + 1;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.onSale = true;
        this.price = price;
        this.image = "@{images/Phone.jpeg}";
    }
}

