package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.Array;
import com.example.demo.model.Item;
import com.example.demo.service.ShoppingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.example.demo.service.ShoppingService.listSplit;

@Slf4j
@Controller
public class ShoppingController {
    @RequestMapping(value = {"/shoppingCart"})
    public String displayLogInPage(Model model) {
        Account currentAccount = (Account) model.asMap().get("currentAccount");
        System.out.println("Logged in / " + currentAccount.isLoggedin());
        System.out.println(currentAccount);
        Item[] shoppingCartList = currentAccount.getShoppingList();
        model.addAttribute("currentAccount", currentAccount);
        model.addAttribute("shoppingCartList", ShoppingService.listSplit(shoppingCartList));

        return "shoppingcart.html";
    }
    @RequestMapping(value = {"/checkShopping"})
    public String checkShopping(@RequestParam String username, RedirectAttributes redirectAttributes) {
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
        return ("redirect:/shoppingCart");
        }
    @RequestMapping(value = {"/addToCart"})
    public String addToCart(@RequestParam int itemId) {
        return "redirect:/signup";
    }
}