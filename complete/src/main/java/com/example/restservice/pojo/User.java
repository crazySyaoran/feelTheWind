package com.example.restservice.pojo;

public class User {
    private int rank;
    private String username;
    private String password;
    private String usertype;
    private int credit;
    private String email;
    private int coin;

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

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
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

    public User(String username, String password, String usertype, java.lang.Integer credit, String email,
                java.lang.Integer coin) {
        this.username = username;
        this.password = password;
        this.usertype = usertype;
        this.credit = credit;
        this.email = email;
        this.coin = coin;
    }

    public User(String username, String usertype, java.lang.Integer credit, java.lang.Integer coin) {
        this.username = username;
        this.usertype = usertype;
        this.credit = credit;
        this.coin = coin;
    }

    public User(String username, java.lang.Integer credit, java.lang.Integer coin) {
        this.username = username;
        this.credit = credit;
        this.coin = coin;
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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
