package com.example.demo.service;

import com.example.demo.controller.SignUpController;
import com.example.demo.model.SignUp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    private static Logger log = LoggerFactory.getLogger(SignUpService.class);

    public boolean saveSignUpInfo(SignUp signUp){
        boolean isSaved = true;
        if (signUp.getPassword() == null || signUp.getPassword().isEmpty() || signUp.getUsername() == null || signUp.getUsername().isEmpty() || signUp.getEmail() == null || signUp.getEmail().isEmpty()) {
            log.error("SignUp info is empty.");
            isSaved = false;
        }
        if (signUp.getPassword().length() < 3 || signUp.getUsername().length() < 3) {
            log.error("Password length should be at least 3 characters.");
            isSaved = false;
        }
        if (!signUp.getEmail().contains("@")){
            log.error("Email address should be a valid email address.");
        }
        log.info(signUp.toString());
        return isSaved;

    }
}
