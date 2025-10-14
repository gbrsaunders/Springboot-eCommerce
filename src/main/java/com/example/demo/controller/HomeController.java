package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
@Slf4j
public class HomeController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = {"/home"})
    public String displayHomePage(Model model) {
        return "home.html";
    }
    @RequestMapping(value = {"/signup"})
    public String displaySignUpPage(@ModelAttribute("errorMessage") String errorMessage) {
        return "signup.html";
    }
    @RequestMapping(value = {"/signout"})
    public String displaySignOutPage(Model model) {
        return "redirect:/login";
    }
    @RequestMapping(value = {"/login", ""})
    public String displaySignUpPage() {
        return "login.html";
    }
    @RequestMapping(value = "/saveSignUp", method = POST)
    public ModelAndView saveSignUp(Account account, RedirectAttributes redirectAttributes) {
        account.setAdmin(false);
        String errorMessage = accountService.saveSignUpInfo(account);
        redirectAttributes.addFlashAttribute("errorMessage", errorMessage);
        return new ModelAndView("redirect:/signup");
    }
    @RequestMapping(value = "/checkLogIn", method = POST)
    public String checkLogIn(Account account, RedirectAttributes redirectAttributes) {
        Account currentAccount = accountService.checkLogIn(account);
        if (currentAccount == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Username or password are incorrect.");
            return "redirect:/login";
        } else if (!currentAccount.getAdmin()) {
            redirectAttributes.addFlashAttribute("currentAccount", currentAccount);
            return "redirect:/home";
        } else if (currentAccount.getAdmin()) {
            redirectAttributes.addFlashAttribute("currentAccount", currentAccount);
            return "redirect:/admin";
        }
        return "redirect:/login";
    }



}
