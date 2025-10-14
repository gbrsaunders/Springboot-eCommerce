package com.example.demo.controller;

import com.example.demo.model.Item;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/addItem")
    public Item postDetails(@RequestBody Item item){
        return itemService.saveDetails(item);
    }
    @GetMapping("/getItemByID/{ID}")
    public Item fetchDetailsByID(@PathVariable int ID) {
        return itemService.getItemByID(ID);
    }
    @PutMapping("/updateItem")
    public Item updateDetails(@RequestBody Item item) {
        return itemService.updateDetail(item);
    }


    @RequestMapping("/item")
    public String getItem(@RequestParam int itemID, @RequestParam String username ) {
        return "item";
    }
    @GetMapping("/item/{ItemID}")
    public String getItemPage(Model model, @PathVariable int ItemID ) {
        Item targetItem = itemService.getItemByID(ItemID);
        if (targetItem != null) {
            model.addAttribute("item", targetItem);
            return "itempage.html";
        }
        else{
            return "redirect:/marketplace";
        }
    }
}
