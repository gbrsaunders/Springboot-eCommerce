package com.example.demo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Item {
    public static int total = 0;
    public int ID;
    public String name;
    public String description;
    public int stock;
    public boolean onSale;
    public float price;

    public Item(String name, String description, int stock, int price) {
        this.ID = total + 1;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.onSale = true;
        total = total + 1;
    }
}

