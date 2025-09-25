package com.example.demo.model;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Account {

    @Setter
    @Getter
    @NotBlank(message = "Username must not be blank")
    @Size(min = 3, message = "Username must be at least 3 characters long")
    private String username;

    @Setter
    @Getter
    @NotBlank(message = "Password must not be blank")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @Setter
    @Getter
    @NotBlank(message = "Email must not be blank")
    @Email(message = "Please provide a valid email address")
    private String email;

    @Setter
    @Getter
    private boolean loggedin;

    public enum type{
        ADMIN,
        USER
    }

    private type AccountType;
    private Item[] shoppingList = new Item[10];
    private Item[] sellingList = new Item[10];

    public Account(String username, String password, String email, type AccountType) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.loggedin = false;
        this.AccountType = AccountType;
    }
    @Override
    public String toString() {
    return "Username: " + username + " || Password: " + password + " || Email: " + email;
    }

    public Account checkData(){
        Account[] accountList = Array.getAccountList();
        for(Account acc : accountList){
            if (acc == null){
                return null;
            }
            if (this.getUsername().equals(acc.getUsername()) && this.getPassword().equals(acc.getPassword())){
                return acc;
            }
        }
        return null;
    }
    public void addShoppingItem(Item item){
        for(int i = 0; i <= this.getShoppingList().length; i++){
            if(this.getShoppingList()[i] == null){
                this.getShoppingList()[i] = item;
                System.out.println("Successfully added item.");
                break;
            }
        }
        System.out.println("Failed adding the item.");
    }
    public void removeShoppingItem(Item item){
        for(int i = 0; i <= this.getShoppingList().length; i++){
            if(this.getShoppingList()[i].name.equals(item.name) && this.getShoppingList()[i].description.equals(item.description) && this.getShoppingList()[i].stock == item.stock && this.getShoppingList()[i].price == item.price){
                this.getShoppingList()[i] = null;
                for(int j = i+1; j <= this.getShoppingList().length; j++){
                    if (this.getShoppingList()[j] == null){
                        return;
                    }
                    this.getShoppingList()[j-1] = this.getShoppingList()[j];
                }
                System.out.println("Successfully added item.");
                break;
            }
        }
        System.out.println("Failed adding the item.");
    }
    public void addSellingItem(Item item){
        for(int i = 0; i <= this.getSellingList().length; i++){
            if(this.getSellingList()[i] == null){
                this.getSellingList()[i] = item;
                System.out.println("Successfully added item.");
                break;
            }
        }
        System.out.println("Failed adding the item.");
    }
    public void removeSellingItem(Item item){
        for(int i = 0; i <= this.getSellingList().length; i++){
            if(this.getSellingList()[i].name.equals(item.name) && this.getShoppingList()[i].description.equals(item.description) && this.getShoppingList()[i].stock == item.stock && this.getShoppingList()[i].price == item.price){
                this.getSellingList()[i] = null;
                for(int j = i+1; j <= this.getSellingList().length; j++){
                    if (this.getSellingList()[j] == null){
                        return;
                    }
                    this.getSellingList()[j-1] = this.getSellingList()[j];
                }
                System.out.println("Successfully added item.");
                break;
            }
        }
        System.out.println("Failed adding the item.");
    }


}
