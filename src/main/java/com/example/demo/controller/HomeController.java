package com.example.demo.controller;

import com.example.demo.model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    @RequestMapping(value = {"","/","/home"})
    public String displayHomePage(Model model) {
        Account currentAccount = (Account) model.asMap().get("currentAccount");
        System.out.println("Logged in / " + currentAccount.isLoggedin());
        System.out.println(currentAccount);
        model.addAttribute("displayUsername", currentAccount.getUsername());
        model.addAttribute("displayEmail", currentAccount.getEmail());
        model.addAttribute("displayPoints", currentAccount.getPoints());
        return "home.html";
    }

}
