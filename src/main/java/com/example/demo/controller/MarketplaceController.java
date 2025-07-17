package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.Array;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class MarketplaceController {
    @RequestMapping(value = {"/marketplace"})
    public String displayLogInPage(Model model) {
        model.addAttribute("marketplaceItems", Array.getMarketplace());
        return "marketplace.html";
    }
}
