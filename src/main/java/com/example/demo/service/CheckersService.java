package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.model.Data;
import org.springframework.stereotype.Service;

@Service
public class CheckersService {
    public String requestMatch(Account account) {
        Account[] AccountList = Data.getAccountList();
        for(Account acc : AccountList) {
            if(acc.isLoggedin()){
                return "" + acc;
            }
        }
        return "Not found";
    }
}