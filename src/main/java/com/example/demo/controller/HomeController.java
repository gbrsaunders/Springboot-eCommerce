package com.example.demo.controller;

import com.example.demo.model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = {"","/","/home"})
    public String displayHomePage(@ModelAttribute("account") Account account, Model model) {
        model.addAttribute("displayUsername", account.getUsername());
        return "home.html";
    }

}
