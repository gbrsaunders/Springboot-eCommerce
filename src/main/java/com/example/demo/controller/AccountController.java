package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/addAccount")
    public Account postDetails(@RequestBody Account account) {
        return accountService.saveDetails(account);
    }
    @GetMapping("/getAccountByID/{ID}")
    public Account fetchDetailsByID(@PathVariable int ID) {
        return accountService.getAccountByID(ID);
    }
    @PutMapping("/updateAccount")
    public Account updateDetails(@RequestBody Account account) {
        return accountService.updateDetail(account);
    }
}