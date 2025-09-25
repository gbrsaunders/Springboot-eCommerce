package com.example.demo;

import com.example.demo.model.Account;
import com.example.demo.model.Array;
import com.example.demo.model.Item;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        Account[] AccountList = Array.getAccountList();
        Item[] ShoppingList2 = new Item[]{new Item("Bear", "A bear", 5,  5),new Item("Phone", "A phone", 5,  5),null,null,null,null,null,null,null,null};
        AccountList[0] = new Account("Bob","Bob","Bob@gmail.com", Account.type.USER);
        AccountList[1] = new Account("Admin","Admin","Admin@gmail.com", Account.type.ADMIN);
        Array.setAccountList(AccountList);
        Array.setMarketplace(ShoppingList2);
        System.out.println(AccountList[0].getAccountType());

    }

}
