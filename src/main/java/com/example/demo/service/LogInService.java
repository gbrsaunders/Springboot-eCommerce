package com.example.demo.service;
import com.example.demo.model.Account;
import com.example.demo.model.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogInService {
    private static Logger log = LoggerFactory.getLogger(LogInService.class);

    public void checkLogIn(Account account){
        Account[] accountList = Data.getAccountList();
        for(Account acc : accountList){

        }
    }
}

