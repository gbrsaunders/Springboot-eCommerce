package com.example.demo;

import com.example.demo.model.Account;
import com.example.demo.model.Array;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        Account[] AccountList = Array.getAccountList();
        AccountList[0] = new Account("Bob","Bob","Bob@gmail.com");
        AccountList[1] = new Account("Jeff","Jeff","Jeff@gmail.com");
        Array.setAccountList(AccountList);
    }

}
