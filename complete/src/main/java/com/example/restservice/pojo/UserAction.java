package com.example.restservice.pojo;

import java.util.List;

public class UserAction {
    private int actionid;
    private String username;
    private String actionname;
    private String actiontime;
    private int creditchange;
    private String actiondetail;

    private String actionDetailCheatSheet[][]={
            {"，同时打开了EDGvsRNG的比赛。", "，并表示今天的肉依然不够多。", "，哇!今天有晕菜！"},
            {"，并觉得现在应该是第三重梦境。"},
            {"，今天一定能睡个好觉！", "，今晚一定能梦见梦中情人！"}
    };

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

    public UserAction(String username, String actionname, String actiontime) {
        this.username = username;
        this.actionname = actionname;
        this.actiontime = actiontime;
        int k = -1;
        if ("breakfast".equals(actionname) || "lunch".equals(actionname) || "supper".equals(actionname)) {
            k = 0;
        }else if ("getup".equals(actionname)) {
            k = 1;
        }else if ("sleep".equals(actionname)) {
            k = 2;
        }
        if (k != -1){
            this.actiondetail = this.actionDetailCheatSheet[k][(int)(Math.random() * this.actionDetailCheatSheet[k].length)];
        }
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
