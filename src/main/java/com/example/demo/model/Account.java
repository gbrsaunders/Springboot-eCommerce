package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "ACCOUNT")
public class Account {
    public Account() {
    }
    @Id
    @Column(name = "USER_ID")
    private int ID;

    @Setter
    @Getter
    @NotBlank(message = "Username must not be blank")
    @Size(min = 3, message = "Username must be at least 3 characters long")
    @Column(name = "USERNAME")
    private String username;

    @Setter
    @Getter
    @NotBlank(message = "Password must not be blank")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    @Column(name = "PASSWORD")
    private String password;

    @Setter
    @Getter
    @NotBlank(message = "Email must not be blank")
    @Email(message = "Please provide a valid email address")
    @Column(name = "EMAIL")
    private String email;

    public enum type{
        ADMIN,
        USER
    }
    @Column(name = "TYPE")
    private type AccountType;
    @Getter
    @Setter
    @OneToMany
    @JoinColumn(name = "ID")
    private List<Item> shoppingList = new ArrayList<>();
    @Getter
    @Setter
    @OneToMany
    @JoinColumn(name = "ID")
    private List<Item> sellingList = new ArrayList<>();

    public Account(String username, String password, String email, type AccountType) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.AccountType = AccountType;
    }
    @Override
    public String toString() {
    return "Username: " + username + " || Password: " + password + " || Email: " + email;
    }

    public Account checkData(){
        List<Account> accountList = Array.getAccountList();
        for(Account acc : accountList){
            if (this.getUsername().equals(acc.getUsername()) && this.getPassword().equals(acc.getPassword())){
                return acc;
            }
        }
        return null;
    }
    public void addShoppingItem(Item item){
        getShoppingList().add(item);
    }
    public void removeShoppingItem(Item item){
        for(Item i : this.getShoppingList()){
            if(i.name.equals(item.name) && i.description.equals(item.description) && i.stock == item.stock && i.price == item.price){
                getShoppingList().remove(i);
                System.out.println("Successfully added item.");
                break;
            }
        }
        System.out.println("Failed adding the item.");
    }
    public void addSellingItem(Item item){
        getSellingList().add(item);
    }
    public void removeSellingItem(Item item){
        for(Item i : this.getSellingList()){
            if(i.name.equals(item.name) && i.description.equals(item.description) && i.stock == item.stock && i.price == item.price){
                getSellingList().remove(i);
                System.out.println("Successfully added item.");
                break;
            }
        }
        System.out.println("Failed adding the item.");
    }


}
