package com.example.demo.model;

public class Data {
    private static Account[] AccountList = new Account[10];

    public static Account[] getAccountList() {
        return AccountList;
    }

    public static void setAccountList(Account[] accountList) {
        AccountList = accountList;
    }
}
