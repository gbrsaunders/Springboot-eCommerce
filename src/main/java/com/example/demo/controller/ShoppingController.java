package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.Item;
import com.example.demo.service.AccountService;
import com.example.demo.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
@Slf4j
@Controller
public class ShoppingController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private ItemService itemService;
    @RequestMapping(value = {"/shoppingCart"})
    public String displayLogInPage(@ModelAttribute("currentAccount") Account currentAccount, Model model) {
        currentAccount = accountService.getAccountByID(currentAccount.getID());
        List<Item> shoppingCartList = currentAccount.getShoppingCart();
        model.addAttribute("currentAccount", currentAccount);
        model.addAttribute("shoppingCartList", itemService.listSplit(shoppingCartList));
        return "shoppingcart.html";
    }
    @RequestMapping(value = {"/checkShopping"})
    public String checkShopping(@RequestParam String username, RedirectAttributes redirectAttributes) {
        Account currentAccount = accountService.checkLogInUsername(username);
        if(currentAccount == null) {
            log.error("Account cannot be found for Shopping Cart");
            return "redirect:/login";
        }
        redirectAttributes.addFlashAttribute("currentAccount", currentAccount);
        return ("redirect:/shoppingCart");
        }
    @RequestMapping(value = {"/addToCart"})
    public String addToCart(@RequestParam int itemID, @RequestParam String username, RedirectAttributes redirectAttributes) {

        Item item = itemService.getItemByID(itemID);
        Account currentAccount = accountService.checkLogInUsername(username);
        if(currentAccount == null){
            log.error("Account cannot be found for Shopping Cart. Username: {}", username);
            return ("redirect:/marketplace");
        }
        else{
            currentAccount.addShoppingItem(item);
            accountService.saveDetails(currentAccount);
              redirectAttributes.addFlashAttribute("currentAccount", currentAccount);
              return ("redirect:/shoppingCart");
        }
    }
    @RequestMapping(value = {"/removeFromCart"})
    public String removeFromCart(@RequestParam int itemID, @RequestParam String username, RedirectAttributes redirectAttributes) {

        Item item = itemService.getItemByID(itemID);
        Account currentAccount = accountService.checkLogInUsername(username);
        if(currentAccount == null){
            log.error("Account cannot be found for Shopping Cart. Username: {}", username);
            return ("redirect:/marketplace");
        }
        else{
            currentAccount.removeShoppingItem(item);
            accountService.saveDetails(currentAccount);
            redirectAttributes.addFlashAttribute("currentAccount", currentAccount);
            return ("redirect:/shoppingCart");
        }
    }
}