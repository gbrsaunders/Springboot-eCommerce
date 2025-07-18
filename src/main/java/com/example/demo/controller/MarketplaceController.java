package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.Array;
import com.example.demo.service.ShoppingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MarketplaceController {
    @RequestMapping(value = {"/marketplace"})
    public String displayMarketplace(Model model) {
        model.addAttribute("marketplaceList", ShoppingService.listSplit(Array.getMarketplace()));
        return "marketplace.html";
    }
}
