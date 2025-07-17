package com.example.demo.service;
import com.example.demo.model.Account;
import com.example.demo.model.Array;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogInService {
    private static Logger log = LoggerFactory.getLogger(LogInService.class);

    public Account checkLogIn(Account accountEntered){
        Account[] AccountList = Array.getAccountList();
        if (accountEntered.getUsername() == null | accountEntered.getPassword() == null){
            log.error("Username or password are empty");
            return null;
        }
        for(Account account : AccountList){
            if(account.getUsername().equals(accountEntered.getUsername()) && account.getPassword().equals(accountEntered.getPassword())){
                return account;
            }
        }
        return null;

    }

}

