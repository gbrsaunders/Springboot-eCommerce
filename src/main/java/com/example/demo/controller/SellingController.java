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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Slf4j
@Controller
public class SellingController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = {"/selling"})
    public String displaySellingPage(@ModelAttribute("currentAccount") Account currentAccount, Model model) {
        System.out.println(currentAccount);
        currentAccount = accountService.getAccountByID(currentAccount.getID());
        List<Item> sellingList = currentAccount.getSellingList();
        model.addAttribute("currentAccount", currentAccount);
        model.addAttribute("shoppingCartList", itemService.listSplit(sellingList));

        return "sellingList.html";
    }
    @RequestMapping(value = {"/checkSelling"})
    public String checkSelling(@RequestParam String username, RedirectAttributes redirectAttributes) {
        Account currentAccount = accountService.checkLogInUsername(username);
        if(currentAccount == null) {
            log.error("Account cannot be found for Shopping Cart");
            return "redirect:/login";
        }
        redirectAttributes.addFlashAttribute("currentAccount", currentAccount);
        return ("redirect:/selling");
    }
    @RequestMapping(value = {"/sellingMenu"})
    public String displaySellingPage(@RequestParam String username, Model model) {
        Account currentAccount = accountService.checkLogInUsername(username);
        model.addAttribute("currentAccount", currentAccount);
        return "sellingMenu.html";
    }
    @RequestMapping(value = {"/checkItem"})
    public String checkItem(@RequestParam("file") MultipartFile file, @RequestParam String username, @RequestParam String name, @RequestParam String price, @RequestParam String description, @RequestParam String stock, RedirectAttributes redirectAttributes, Model model) throws IOException {
        Account currentAccount = accountService.checkLogInUsername(username);
        String path = "src/main/resources/static/images/Picture";
        String fileName = currentAccount.getID() + ".jpg";

        System.out.println("Item: " + name + " " + price + " " + description + " " + stock);
        try{
            System.out.println("Image Tried To Be Uploaded");
            String filePath = path + File.separator + fileName;
            Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(name == null  || stock == null) {
            redirectAttributes.addFlashAttribute("currentAccount", currentAccount);
            return ("redirect:/marketplace");

        }
        else{
            int intStock = Integer.parseInt(stock);
            int intPrice = Integer.parseInt(price);
            Item item = new Item(name,description,intStock,intPrice);
            itemService.addImageToItem(item, file);
            currentAccount.addSellingItem(item);
            accountService.saveDetails(currentAccount);
            System.out.println("Success");
        }

        redirectAttributes.addFlashAttribute("currentAccount", currentAccount);
        return ("redirect:/marketplace");
    }



}