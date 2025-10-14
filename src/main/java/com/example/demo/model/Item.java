package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "ITEM")
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "INFO")
    private String description;

    @Column(name = "STOCK")
    private int stock;

    @Column(name = "ONSALE")
    private boolean onSale;

    @Column(name = "PRICE")
    private float price;

    @ManyToMany(mappedBy = "shoppingCart")
    private List<Account> shoppers = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "selling_owner_id")
    private Account sellingOwner;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;

    public Item(String name, String description, int stock, float price) {
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.onSale = true;
    }
}