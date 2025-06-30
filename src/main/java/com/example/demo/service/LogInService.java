package com.example.demo.service;
import com.example.demo.model.Account;
import com.example.demo.model.Array;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogInService {
    private static Logger log = LoggerFactory.getLogger(LogInService.class);

    public String checkLogIn(Account accountEntered){
        Account[] accountList = Array.getAccountList();
        if (accountEntered.getUsername() == null | accountEntered.getPassword() == null){
            log.error("Username or password are empty");
            return "Username or password are empty.";
        }
        if(accountEntered.checkData() != null){
            return null;
        }
        else{
            return "Account not found or doesn't exists";
        }
    }

}

