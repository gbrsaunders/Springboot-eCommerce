package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;

    public Account saveDetails(Account account){
        return accountRepo.save(account);
    }
}
