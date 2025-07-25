package com.example.demo.service;
import com.example.demo.model.Account;
import com.example.demo.model.Array;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class LogInService {
    private static Logger log = LoggerFactory.getLogger(LogInService.class);

    public Account checkLogIn(Account accountEntered){
        Account[] AccountList = Array.getAccountList();
        if (accountEntered.getUsername() == null | accountEntered.getPassword() == null){
            log.error("Username or password are empty");
            return null;
        }
        for(Account account : AccountList){
            if(account == null) {
                log.error("End of AccountList");
                return null;
            }
            else if(account.getUsername().equals(accountEntered.getUsername()) && account.getPassword().equals(accountEntered.getPassword())){
                return account;
            }
        }
        return null;

    }
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

}

