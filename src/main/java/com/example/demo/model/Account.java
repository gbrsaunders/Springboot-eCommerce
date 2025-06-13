package com.example.demo.model;

public class Account {
    private String username;
    private String password;
    private String email;
    private int points = 0;
    private boolean loggedin = false;

    public Account(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.loggedin = false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
    return "Username: " + username + " || Password: " + password + " || Email: " + email;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    public Account checkData(){
        Account[] accountList = Data.getAccountList();
        for(Account acc : accountList){
            if (acc == null){
                return null;
            }
            if (this.getUsername().equals(acc.getUsername()) && this.getPassword().equals(acc.getPassword())){
                return acc;
            }
        }
        return null;
    }

    public boolean isLoggedin() {
        return loggedin;
    }

    public void setLoggedin(boolean loggedin) {
        this.loggedin = loggedin;
    }
}
