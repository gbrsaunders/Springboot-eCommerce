package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.service.LogInService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
@Slf4j
@Controller
public class LogInController {
    private final LogInService logInService;

    @Autowired
    public LogInController(LogInService logInService) {
        this.logInService = logInService;
    }

    @RequestMapping(value = {"/login", "/signout"})
    public String displayLogInPage(@ModelAttribute("errorMessage") String errorMessage, Model model) {
        model.addAttribute("errorMessage", errorMessage);
        return "login.html";
    }


    @RequestMapping(value = "/checkLogIn", method = POST)
    public String checkLogIn(Account account, RedirectAttributes redirectAttributes) {
        Account currentAccount = logInService.checkLogIn(account);
        if (currentAccount == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Username or password are incorrect.");
            return "redirect:/login";
        } else if (currentAccount.getAccountType() == Account.type.USER) {
            redirectAttributes.addFlashAttribute("currentAccount", currentAccount);
            return "redirect:/home";
        } else if (currentAccount.getAccountType() == Account.type.ADMIN) {
            redirectAttributes.addFlashAttribute("currentAccount", currentAccount);
            return "redirect:/admin";
        }
        log.error("Very weird exception");
        System.out.println(account.getAccountType());
        return "redirect:/login";
    }
    @GetMapping("/path")
    public String getPath(@RequestParam("username") String username, @RequestParam("password") String password, RedirectAttributes redirectAttributes) {
        /*
        Account currentAccount = logInService.checkLogInUsername(username);
        currentAccount = logInService.checkLogIn(currentAccount);
        redirectAttributes.addFlashAttribute("currentAccount", currentAccount);
        */
         System.out.println(username);
         System.out.println(password);
        return "bob";
    }
}
