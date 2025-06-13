package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.model.Data;
import org.springframework.stereotype.Service;

@Service
public class CheckersService {
    public String requestMatch(Account account) {
        Account[] AccountList = Data.getAccountList();
        for(Account acc : AccountList) {
            if(acc.isLoggedin() && acc.getUsername() != null){
                System.out.println(acc.getUsername() + "is logged in");
                if (!acc.getUsername().equals(account.getUsername())) {
                    System.out.println(account.getUsername() + " | "  + acc.getUsername());
                    return acc + " is eligible";
                }
            }
        }
        return "Not found";
    }
}