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
            {"，同时打开了EDGvsRNG的比赛。", "，并表示今天的肉依然不够多。", "，哇!今天有晕菜！", "，呀，下饭还是胡凯莉下饭。",
                    "，并觉得健康饮食才是关键。", "！哇，世界上还有什么比美食更令人开心的么QWQ", "宝宝要吃肉！！RUA！",
                    "，今天突然发现蔬菜也有很好吃的嘛~ 嘿嘿XD", "，顺便饭后去散散步怎么样？", "，啊...好想要新垣结衣给我做饭呀...",
                    "，每天思考吃什么也很有一份独特的乐趣不是么hh"},
            {"，并觉得现在应该是第三重梦境。", "，并觉得现在应该是第四重梦境。", "，并觉得现在应该是第五重梦境。",
                    "，早起的鸟儿有虫吃~", "，并突然有预感今天一定会有什么好事情发生！", "，又是崭新的一天！",  "，一日之计在于晨！",
                    "，一日之计在于日辰（XD", "，Happy new day!", "，看到了昨日逝去的人梦寐以求的「明天」，要好好珍惜呀！",
                    "~ 快去享用早饭！", "... 嗯？0.0 好饿！", "，今日运势五星！", "今天也要努力让自己开心哦QWQ",},
            {"，今天一定能睡个好觉！", "，今晚一定能梦见梦中情人！", "，今天的口号是！专心睡觉！不玩手机！", "，啊~ 又是充实的一天~",
                    "，睡前试着给一个自己不喜欢的人找一个优点怎么样？", "，今天的被子里有阳光的香味~", "晚~安QwQ", "明天又是崭新的一天~"}
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
