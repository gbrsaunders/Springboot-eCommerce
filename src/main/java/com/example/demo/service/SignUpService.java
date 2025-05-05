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
        log.info(signUp.toString());
        return isSaved;

    }
}
