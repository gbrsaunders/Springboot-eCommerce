package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Array {
    @Getter @Setter
    private static Account[] AccountList = new Account[10];
    @Getter @Setter
    private static Item[] Marketplace = new Item[100];

}
