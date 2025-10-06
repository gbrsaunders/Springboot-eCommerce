package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "ITEM")
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    public static int total = 0;
    @Id
    @Column(name = "ID")
    @JoinColumn(name = "ID")
    public int ID;
    @Column(name = "NAME")
    public String name;
    @Column(name = "INFO")
    public String description;
    @Column(name = "STOCK")
    public int stock;
    @Column(name = "ONSALE")
    public boolean onSale;
    @Column(name = "PRICE")
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

