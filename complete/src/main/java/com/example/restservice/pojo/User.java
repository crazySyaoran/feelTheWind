package com.example.restservice.pojo;

public class User {
    private String username;
    private String usertype;
    private int credit;

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


}
