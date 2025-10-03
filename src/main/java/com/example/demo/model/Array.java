package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
public class Array {
    @Getter @Setter
    private static List<Account>  AccountList = new ArrayList<>();
    @Getter @Setter
    private static List<Item> Marketplace = new ArrayList<>();

}
