package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.Array;
import com.example.demo.model.Item;
import com.example.demo.service.LogInService;
import com.example.demo.service.ShoppingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import static com.example.demo.service.ShoppingService.listSplit;

@Slf4j
@Controller
public class ShoppingController {
    private final LogInService logInService;

    public ShoppingController(LogInService logInService) {
        this.logInService = logInService;
    }

    @RequestMapping(value = {"/shoppingCart"})
    public String displayLogInPage(@ModelAttribute("currentAccount") Account currentAccount, Model model) {
        System.out.println(currentAccount);
        List<Item> shoppingCartList = currentAccount.getShoppingList();
        model.addAttribute("currentAccount", currentAccount);
        model.addAttribute("shoppingCartList", ShoppingService.listSplit(shoppingCartList));
        return "shoppingcart.html";
    }
    @RequestMapping(value = {"/checkShopping"})
    public String checkShopping(@RequestParam String username, RedirectAttributes redirectAttributes) {
        Account currentAccount = logInService.checkLogInUsername(username);
        if(currentAccount == null) {
            log.error("Account cannot be found for Shopping Cart");
            return "redirect:/login";
        }
        redirectAttributes.addFlashAttribute("currentAccount", currentAccount);
        return ("redirect:/shoppingCart");
        }
    @RequestMapping(value = {"/addToCart"})
    public String addToCart(@RequestParam int itemID, @RequestParam String username, RedirectAttributes redirectAttributes) {
        Item chosenItem = null;
        for(Item item : Array.getMarketplace()){
          if(item == null){
              log.error("Item cannot be found for Shopping Cart. Item ID: {}", itemID);
              return ("redirect:/marketplace");
          }
          System.out.println("ItemID: " + item.ID + "Target ID: " + itemID);
          if(item.ID == itemID){
              chosenItem = item;
              System.out.println("ItemID: " + itemID);
              Account currentAccount = logInService.checkLogInUsername(username);
              System.out.println(currentAccount);
              if(currentAccount == null){
                  log.error("Account cannot be found for Shopping Cart. Username: {}", username);
                  return ("redirect:/marketplace");
              }
              else{
                  List<Item> shoppingCartList = currentAccount.getShoppingList();
                  shoppingCartList.add(item);
                  currentAccount.setShoppingList(shoppingCartList);
                  redirectAttributes.addFlashAttribute("currentAccount", currentAccount);
                  System.out.println("AddToCart Username:" + currentAccount.getUsername());
                  return ("redirect:/marketplace");
              }
          }
        }
        return null;
    }
}