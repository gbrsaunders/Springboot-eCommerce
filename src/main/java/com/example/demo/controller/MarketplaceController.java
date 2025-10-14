package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;
import com.example.demo.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
public class MarketplaceController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private ItemService itemService;
    @RequestMapping(value = {"/marketplace"})
    public String displayMarketplace(Model model) {
        model.addAttribute("marketplaceList", itemService.listSplit(itemService.getItems()));
        return "marketplace.html";
    }

    @RequestMapping(value = {"/checkMarketplace"})
    public String checkMarketplace(@RequestParam String username, RedirectAttributes redirectAttributes) {
        Account currentAccount = accountService.checkLogInUsername(username);
        if (currentAccount == null) {
            log.error("Account cannot be found for Marketplace");
            return "redirect:/login";
        }
        redirectAttributes.addFlashAttribute("currentAccount", currentAccount);
        System.out.println("Redirecting to Marketplace");
        return ("redirect:/marketplace");
    }
    @RequestMapping(value = {"/checkHome"})
    public String checkHome(@RequestParam String username, @RequestParam String password, RedirectAttributes redirectAttributes) {
        System.out.println("Check Home");
        Account currentAccount = accountService.checkLogInUsername(username);
        if (currentAccount == null) {
            log.error("Account cannot be found for Home");
            return "redirect:/login";
        }
        redirectAttributes.addFlashAttribute("currentAccount", currentAccount);
        System.out.println("Redirecting to Home");
        System.out.println(currentAccount);
        return "redirect:/home";
    }
}


