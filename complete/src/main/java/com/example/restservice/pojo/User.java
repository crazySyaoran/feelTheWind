package com.example.restservice.pojo;

public class User {
    private String username;
    private String password;
    private String usertype;
    private int credit;
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public User(String username, String usertype, int credit){
        super();
        this.username = username;
        this.usertype = usertype;
        this.credit = credit;
    }

    public User(java.lang.String username, java.lang.String usertype, java.lang.Integer credit){
        super();
        this.username = username;
        this.usertype = usertype;
        this.credit = credit;
    }

    public User(String username, String password, String usertype, int credit) {
        this.username = username;
        this.password = password;
        this.usertype = usertype;
        this.credit = credit;
    }

    public User(String username, String password, String usertype, int credit, String email) {
        this.username = username;
        this.password = password;
        this.usertype = usertype;
        this.credit = credit;
        this.email = email;
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
}
