package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.model.Array;
import org.springframework.stereotype.Service;

@Service
public class CheckersService {
    public Account requestMatch(Account account) {
        if (account.isReadyMatch()) {
            account.setReadyMatch(false);
            System.out.println(account.getUsername() + " is not ready.");
        } else {
            account.setReadyMatch(true);
            Account[] AccountList = Array.getAccountList();
            System.out.println(account.getUsername() + " is ready.");
            for (Account acc : AccountList) {
                if (acc == null){
                    continue;
                }
                if (acc.isReadyMatch() && acc.getUsername() != null) {
                    if (!acc.getUsername().equals(account.getUsername())) {
                        System.out.println(account.getUsername() + " | " + acc.getUsername());
                        return acc;
                    }
                }
            }
            return null;
        }
        return null;
    }
}