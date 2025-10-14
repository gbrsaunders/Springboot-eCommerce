package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;

    public Account saveDetails(Account account){
        return accountRepo.save(account);
    }
    public Account getAccountByID(int ID) {
        return accountRepo.findById(ID).orElse(null);
    }
    public Account updateDetail(Account account){
        Account updatedAccount = accountRepo.findById(account.getID()).orElse(null);
        if(updatedAccount != null){
            updatedAccount.setEmail(account.getEmail());
            updatedAccount.setPassword(account.getPassword());
            updatedAccount.setUsername(account.getUsername());
            updatedAccount.setAdmin(account.getAdmin());
            updatedAccount.setShoppingCart(account.getShoppingCart());
            updatedAccount.setSellingList(account.getSellingList());
            updatedAccount.setID(account.getID());
            accountRepo.save(updatedAccount);
            return updatedAccount;

        }
        return null;
    }
    public String saveSignUpInfo(Account account) {

        if (account.getPassword() == null || account.getPassword().isEmpty()
                || account.getUsername() == null || account.getUsername().isEmpty()
                || account.getEmail() == null || account.getEmail().isEmpty()) {
            return "Fields are empty.";
        }

        if (account.getPassword().length() < 3 || account.getUsername().length() < 3) {
            return "Password length should be at least 3 characters.";
        }

        if (!account.getEmail().contains("@") || !account.getEmail().contains(".")) {
            return "Email address should be a valid email address.";
        }

        if (accountRepo.findByUsername(account.getUsername()).isPresent()) {
            return "Username already exists.";
        }

        if (accountRepo.findByEmail(account.getEmail()).isPresent()) {
            return "Email address already exists.";
        }

        System.out.println("Saving account info...");
        accountRepo.save(account);

        return "Account saved successfully";
    }

    public Account checkLogIn(Account accountEntered) {
        if (accountEntered.getUsername() == null || accountEntered.getPassword() == null) {
            return null;
        }

        return accountRepo.findByUsernameAndPassword(accountEntered.getUsername(), accountEntered.getPassword()).orElse(null);
    }
    public Account checkLogInUsername(String username) {

        return accountRepo.findByUsername(username).orElse(null);
    }
    /*
    public Account checkLogInUsername(String username) {
        Account currentAccount = null;
        for(Account acc : Array.getAccountList()){
            if (acc.getUsername() == null){
                break;
            }
            System.out.println("Looking at Account: " + acc.getUsername() + " Username: " + username);
            if(acc.getUsername().equals(username)){
                currentAccount = acc;
                return currentAccount;
            }
        }
        return currentAccount;
    }

     */
}
