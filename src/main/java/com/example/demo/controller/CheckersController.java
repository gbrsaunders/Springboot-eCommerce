package com.example.demo.controller;

import com.example.demo.service.CheckersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CheckersController {
    private final CheckersService checkersService;

    @Autowired
    public CheckersController(CheckersService checkersService) {
        this.checkersService = checkersService;
    }

    @RequestMapping(value = {"/requestMatch"})
    public ModelAndView requestMatch() {
        System.out.println("requestMatch");
        checkersService.requestMatch()
        return new ModelAndView("redirect:/signup");
    }
}
