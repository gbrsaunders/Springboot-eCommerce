package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Entity
@Table(name = "ITEM")
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

    public Item() {

    }
}

