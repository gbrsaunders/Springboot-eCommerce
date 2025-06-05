package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.service.LogInService;
import org.springframework.ui.Model;
import com.example.demo.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String displayLogInPage(@ModelAttribute("errorMessage") String errorMessage, Model model) {
        model.addAttribute("errorMessage", errorMessage);
        return "login.html";
    }


    @RequestMapping(value = "/checkLogIn", method = POST)
    public ModelAndView checkLogIn(Account account){
        String errorMessage = logInService.checkLogIn(account);
        if (errorMessage != null) {
            return new ModelAndView("redirect:/login", "errorMessage", errorMessage);
        }
        else {
            return new ModelAndView("redirect:/home", "account", account);
        }
    }
}
