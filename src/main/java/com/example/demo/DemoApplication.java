package com.example.demo;

import com.example.demo.model.Account;
import com.example.demo.model.Array;
import com.example.demo.model.Item;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        List<Account> AccountList = Array.getAccountList();
        AccountList.add(new Account("Bob","Bob","Bob@gmail.com", Account.type.USER));
        AccountList.add(new Account("Admin","Admin","Admin@gmail.com", Account.type.ADMIN));
        Array.setAccountList(AccountList);

    }

}
