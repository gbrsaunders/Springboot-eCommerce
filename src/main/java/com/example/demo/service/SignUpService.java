package com.example.demo.service;

import com.example.demo.model.Array;
import com.example.demo.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    private static Logger log = LoggerFactory.getLogger(SignUpService.class);

    public String saveSignUpInfo(Account account) {

        if (account.getPassword() == null || account.getPassword().isEmpty() || account.getUsername() == null || account.getUsername().isEmpty() || account.getEmail() == null || account.getEmail().isEmpty()) {
            log.error("Fields are empty.");
            return "Fields are empty.";
        }
        if (account.getPassword().length() < 3 || account.getUsername().length() < 3) {
            log.error("Password length should be at least 3 characters.");
            return "Password length should be at least 3 characters.";
        }
        if (!account.getEmail().contains("@") && !account.getEmail().contains(".")) {
            log.error("Email address should be a valid email address.");
            return "Email address should be a valid email address.";
        }

        for (Account acc : Array.getAccountList()) {
            if (acc.getUsername().equals(account.getUsername())) {
                log.info("Username already exists.");
                return "Username already exists.";
            }
            else if (acc.getEmail().equals(account.getEmail())) {
                log.info("Email address already exists.");
                return "Email address already exists.";
            }
        }
        System.out.println("Saving account info...");
        Array.getAccountList().add(account);
        return "Account saved successfully";
    }


}
