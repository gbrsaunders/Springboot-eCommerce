package com.example.demo;

import com.example.demo.model.Item;
import com.example.demo.service.ShoppingService;

public class test {
    public static void main(String[] args) {
        Item[] ShoppingList = new Item[]{new Item("Bear", "A bear", 5, true, 5),
                new Item("Bear", "A bear", 5, true, 5),
                new Item("Bear", "A bear", 5, true, 5),
                new Item("Bear", "A bear", 5, true, 5),
                new Item("Bear", "A bear", 5, true, 5),
                new Item("Bear", "A bear", 5, true, 5),
                new Item("Bear", "A bear", 5, true, 5),
                new Item("Bear", "A bear", 5, true, 5),
                new Item("Bear", "A bear", 5, true, 5),
                new Item("Bear", "A bear", 5, true, 5),
                new Item("Bear", "A bear", 5, true, 5),
                new Item("Bear", "A bear", 5, true, 5), new Item("Bear", "A bear", 5, true, 5), new Item("Bear", "A bear", 5, true, 5), new Item("Bear", "A bear", 5, true, 5), new Item("Bear", "A bear", 5, true, 5), new Item("Bear", "A bear", 5, true, 5), new Item("Bear", "A bear", 5, true, 5), new Item("Bear", "A bear", 5, true, 5)};
        System.out.println(ShoppingService.listSplit(ShoppingList));
    }
}
