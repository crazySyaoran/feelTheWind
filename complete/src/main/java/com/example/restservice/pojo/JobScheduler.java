package com.example.restservice.pojo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.example.restservice.mapper.ActionMapper;
import com.example.restservice.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobScheduler {
    @Autowired UserMapper userMapper;
    @Autowired ActionMapper actionMapper;
    public int userNum = 2;

    public void addAiAction(int userNum, String actionName, int creditChange) {
        // userNum是选几个AI进行动作；随机区间是当前时间往前的20分钟内
        List<String> randusers = userMapper.randuser(userNum);
        for(int i=0; i<userNum; i+=1) {
            if (creditChange==1){
                userMapper.aiAddCredit_1(randusers.get(i));
            }else if (creditChange==2) {
                userMapper.aiAddCredit_2(randusers.get(i));
            }else if (creditChange==3) {
                userMapper.aiAddCredit_3(randusers.get(i));
            }


            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.MINUTE, -(int)(Math.random()*20));
            c.add(Calendar.SECOND, -(int)(Math.random()*60));
            Date randDate = c.getTime();

            String now = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(randDate);
            UserAction ua = new UserAction(randusers.get(i), actionName, now, creditChange, "");
            actionMapper.save(ua);
        }
    }

    @Scheduled(cron = "0 0 5 * * ?")
    public void payspend() {
//        System.out.print("PAYED");
        userMapper.payUser();
        userMapper.spendUser();
    }

    // 以下是AI的随机动作
    // 起床 9:50~10:10
    @Scheduled(cron = "0 10 10 * * ?")
    public void aiGetUp() {
        this.addAiAction(this.userNum, "getup", 1);
        System.out.println("DONE");
    }

    // 午饭 10:40~11:00
    @Scheduled(cron = "0 0 11 * * ?")
    public void aiLunch() {
        this.addAiAction(this.userNum, "lunch", 1);
    }

    // 晚饭 18:05~18:25
    @Scheduled(cron = "0 25 18 * * ?")
    public void aiSupper() {
        this.addAiAction(this.userNum, "supper", 2);
    }

    // 睡觉 00:30~00:50
    @Scheduled(cron = "0 50 0 * * ?")
    public void aiSleep() {
        this.addAiAction(this.userNum, "sleep", 1);
    }
}