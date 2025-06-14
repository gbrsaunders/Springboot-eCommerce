package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.Data;
import com.example.demo.service.CheckersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sound.midi.SysexMessage;

@Controller
public class CheckersController {
    private final CheckersService checkersService;

    @Autowired
    public CheckersController(CheckersService checkersService) {
        this.checkersService = checkersService;
    }

    @RequestMapping(value = {"/requestMatch"})
    public ModelAndView requestMatch(@RequestParam String username, RedirectAttributes redirectAttributes) {
        System.out.println("Button clicked - " + username);
        Account currentAccount = null;
        Account[] AccountData = Data.getAccountList();
        for (Account acc : AccountData) {
            if(acc == null){
                continue;
            }
            if (acc.getUsername().equals(username)){
                currentAccount = acc;
            }
        }
        if(currentAccount == null){
            System.out.println("Account not found");
            return new ModelAndView("redirect:/login");
        }
        else{
            System.out.println(checkersService.requestMatch(currentAccount));
            redirectAttributes.addFlashAttribute("currentAccount", currentAccount);
            return new ModelAndView("redirect:/home");
        }

    }
}
