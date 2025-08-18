package com.example.demo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Item {
    public static int total = 0;
    public int ID;
    @NotBlank
    @Size(min = 2, max = 20)
    public String name;
    @NotBlank
    @Size(min = 10, max = 200)
    public String description;
    @NotBlank
    @Size(min = 1, max = 50)
    public int stock;
    public boolean onSale;
    @NotBlank
    @Size(min = 1, max = 500 )
    public float price;
    @NotBlank
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

