package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.Array;
import com.example.demo.service.LogInService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Slf4j
@Controller
public class SellingController {
    private final LogInService logInService;

    public SellingController(LogInService logInService) {
        this.logInService = logInService;
    }

    @RequestMapping(value = {"/selling"})
    public String displaySellingPage(Model model) {
        Account currentAccount = (Account) model.asMap().get("currentAccount");
        System.out.println("Logged in / " + currentAccount.isLoggedin());
        System.out.println(currentAccount);
        model.addAttribute("currentAccount", currentAccount);
        model.addAttribute("sellingList", currentAccount.getSellingList());
        return "selling.html";
    }
    @RequestMapping(value = {"/checkSelling"})
    public String checkSelling(@RequestParam String username, RedirectAttributes redirectAttributes) {
        Account currentAccount = logInService.checkLogInUsername(username);
        if(currentAccount == null) {
            log.error("Account cannot be found for Shopping Cart");
            return "redirect:/login";
        }
        redirectAttributes.addFlashAttribute("currentAccount", currentAccount);
        return ("redirect:/selling");
    }



}