package com.example.demo.controller;

import com.example.demo.model.Array;
import com.example.demo.model.Item;
import com.example.demo.service.ShoppingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ItemController {

    @RequestMapping("/item")
    public String getItem(@RequestParam int itemID, @RequestParam String username ) {
        return "item";
    }
    @GetMapping("/item/{ItemID}")
    public String getItemPage(Model model, @PathVariable int ItemID ) {
        Item targetItem = null;
        for(Item item : Array.getMarketplace()){
            if(item.name == null){
                return "redirect:/marketplace";
            }
            if(item.ID == ItemID){
                System.out.println(item.ID);
                targetItem = item;
                break;
            }
        }
        model.addAttribute("item", targetItem);
        return "itempage.html";
    }
}
