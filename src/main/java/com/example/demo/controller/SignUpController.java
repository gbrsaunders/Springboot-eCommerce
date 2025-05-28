package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.service.SignUpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class SignUpController {

    private final SignUpService signUpService;

    @Autowired
    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @RequestMapping(value = {"/signup"})
    public String displaySignUpPage() {
        return "signup.html";
    }
    @RequestMapping(value = "/saveSignUp", method = POST)
    public ModelAndView saveSignUp(Account account){
        signUpService.saveSignUpInfo(account);
        return new ModelAndView("redirect:/signup");
    }
}
