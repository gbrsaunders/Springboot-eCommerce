package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.service.LogInService;
import com.example.demo.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class LogInController {

    private final LogInService logInService;

    @Autowired
    public LogInController(LogInService logInService) {
        this.logInService = logInService;
    }

    @RequestMapping(value = {"/login"})
    public String displayLogInPage() {
        return "login.html";
    }

    @RequestMapping(value = "/checkLogIn", method = POST)
    public ModelAndView saveSignUp(Account account){
        logInService.checkLogIn(account);
        return new ModelAndView("redirect:/login");
    }
}
