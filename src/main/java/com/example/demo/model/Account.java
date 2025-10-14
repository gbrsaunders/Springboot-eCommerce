package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "ACCOUNT")
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @NotBlank(message = "Username must not be blank")
    @Size(min = 3, message = "Username must be at least 3 characters long")
    @Column(name = "USERNAME", unique = true, nullable = false)
    private String username;

    @NotBlank(message = "Password must not be blank")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Please provide a valid email address")
    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name = "Admin")
    private boolean Admin;

    @ManyToMany
    @JoinTable(
            name = "accountShoppingCart",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> shoppingCart = new ArrayList<>();

    @OneToMany(mappedBy = "sellingOwner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> sellingList = new ArrayList<>();

    public Account(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.Admin = false;
    }

    @Override
    public String toString() {
        return "Username: " + username + " || Password: " + password + " || Email: " + email;
    }

    public void addShoppingItem(Item item) {
        shoppingCart.add(item);
        item.getShoppers().add(this);
    }

    public void removeShoppingItem(Item item) {
        if (shoppingCart.removeIf(i -> matchesItem(i, item))) {
            item.getShoppers().remove(this);
            System.out.println("Successfully removed item.");
        } else {
            System.out.println("Failed removing the item.");
        }
    }

    public void addSellingItem(Item item) {
        item.setSellingOwner(this);
        sellingList.add(item);

    }

    public void removeSellingItem(Item item) {
        if (sellingList.removeIf(i -> matchesItem(i, item))) {
            System.out.println("Successfully removed item.");
        } else {
            System.out.println("Failed removing the item.");
        }
    }

    private boolean matchesItem(Item a, Item b) {
        return a.getName().equals(b.getName()) &&
                a.getDescription().equals(b.getDescription()) &&
                a.getStock() == b.getStock() &&
                a.getPrice() == b.getPrice();
    }

    public boolean getAdmin() {
        return Admin;
    }
}
