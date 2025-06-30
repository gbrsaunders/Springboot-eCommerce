package com.example.demo.model;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class Account {

    @NotBlank(message = "Username must not be blank")
    @Size(min = 3, message = "Username must be at least 3 characters long")
    private String username;

    @NotBlank(message = "Password must not be blank")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Please provide a valid email address")
    private String email;

    private int points = 0;
    private boolean loggedin = false;
    private boolean readyMatch = false;

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
        Account[] accountList = Array.getAccountList();
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

    public boolean isReadyMatch() {
        return readyMatch;
    }

    public void setReadyMatch(boolean readyMatch) {
        this.readyMatch = readyMatch;
    }
}
