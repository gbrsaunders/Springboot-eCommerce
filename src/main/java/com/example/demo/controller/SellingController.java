package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.Array;
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
        Account currentAccount = null;
        for(Account acc : Array.getAccountList()){
            if(acc.getUsername().equals(username)){
                currentAccount = acc;
                break;
            }
        }
        if(currentAccount == null) {
            log.error("Account cannot be found for Shopping Cart");
            return "redirect:/login";
        }
        redirectAttributes.addFlashAttribute("currentAccount", currentAccount);
        return ("redirect:/selling");
    }



}