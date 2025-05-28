package com.example.demo.service;

import com.checkers.beans.Person;
import com.example.demo.controller.SignUpController;
import com.example.demo.model.Data;
import com.example.demo.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    private static Logger log = LoggerFactory.getLogger(SignUpService.class);

    public void saveSignUpInfo(Account account){

        boolean isSaved = true;
        if (account.getPassword() == null || account.getPassword().isEmpty() || account.getUsername() == null || account.getUsername().isEmpty() || account.getEmail() == null || account.getEmail().isEmpty()) {
            log.info("SignUp info is empty.");
            isSaved = false;
        }
        if (account.getPassword().length() < 3 || account.getUsername().length() < 3) {
            log.info("Password length should be at least 3 characters.");
            isSaved = false;
        }
        if (!account.getEmail().contains("@")){
            log.info("Email address should be a valid email address.");
            isSaved = false;
        }
        for(Account acc : Data.getAccountList()){
            if (acc == null){
                break;
            }
            else if(acc.getUsername().equals(account.getUsername())){
                log.info("Username already exists.");
                isSaved = false;
                break;
            }
            else if(acc.getEmail().equals(account.getEmail())) {
                log.info("Email address already exists.");
                isSaved = false;
                break;
            }
        }
        if(isSaved){
            for (int i = 0; i < Data.getAccountList().length; i++) {
                if(Data.getAccountList()[i] == null){
                    Data.getAccountList()[i] = account;
                    log.info("Account saved successfully.");
                    break;
                }
        }
        }
        else{
            log.error("Account not saved.");
        }

    }
}
