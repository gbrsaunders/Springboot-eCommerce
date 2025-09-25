package com.example.demo.service;

import com.example.demo.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ShoppingService {
    /*
    public static Item[][] listSplit(Item[] itemList) {
        System.out.println("Length of List" + itemList.length);
        int listCount = (itemList.length / 5) + 1;
        System.out.println("listCount: " + listCount);
        int listRemaining = itemList.length % 5;
        System.out.println("listRemaining: " + listRemaining);
        Item[][] BigList = new Item[listCount] [5];
        for (int i = 0; i < itemList.length; i++) {
            if(itemList[i] == null){
                break;
            }
            System.out.println("BigList[" + i/5 + "][" + i%5 + "]:" );
            BigList[i / 5][i % 5] = itemList[i];
        }

        return BigList;
    }

     */
    public static List<List<Item>> listSplit(Item[] itemList) {
        List<Item> notNullItems = new ArrayList<>();
        for (Item item : itemList) {
            if (item != null) {
                notNullItems.add(item);
            }
        }

        List<List<Item>> RowOf5 = new ArrayList<>();
        for (int i = 0; i < notNullItems.size(); i += 5) {
            int end = Math.min(i + 5, notNullItems.size());
            RowOf5.add(new ArrayList<>(notNullItems.subList(i, end)));
        }
        return RowOf5;
    }
}
