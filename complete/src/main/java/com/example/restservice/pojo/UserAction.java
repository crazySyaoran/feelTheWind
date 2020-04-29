package com.example.restservice.pojo;

public class UserAction {
    private int actionid;
    private String username;
    private String actionname;
    private String actiontime;
    private int creditchange;
    private String actiondetail;

    public UserAction(String username, String actionname, String actiontime, int creditchange, String actiondetail) {
        super();
        this.username = username;
        this.actionname = actionname;
        this.actiontime = actiontime;
        this.creditchange = creditchange;
        this.actiondetail = actiondetail;
    }

    public UserAction(java.lang.Integer actionid, String username, String actionname,
                      String actiontime, java.lang.Integer creditchange, String actiondetail) {
        this.actionid = actionid;
        this.username = username;
        this.actionname = actionname;
        this.actiontime = actiontime;
        this.creditchange = creditchange;
        this.actiondetail = actiondetail;
    }

    public int getActionid() {
        return actionid;
    }

    public String getUsername() {
        return username;
    }

    public String getActionname() {
        return actionname;
    }

    public String getActiontime() {
        return actiontime;
    }

    public int getCreditchange() {
        return creditchange;
    }

    public String getActiondetail() {
        return actiondetail;
    }

    public void setActionid(int actionid) {
        this.actionid = actionid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setActionname(String actionname) {
        this.actionname = actionname;
    }

    public void setActiontime(String actiontime) {
        this.actiontime = actiontime;
    }

    public void setCreditchange(int creditchange) {
        this.creditchange = creditchange;
    }

    public void setActiondetail(String actiondetail) {
        this.actiondetail = actiondetail;
    }

}
