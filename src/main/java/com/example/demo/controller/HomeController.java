package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = {"","/","/signup"})
    public String displayHomePage(Model model) {
        model.addAttribute("username", "Bobb Doe");
        return "signup.html";
    }

}
