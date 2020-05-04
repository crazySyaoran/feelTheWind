package com.example.restservice.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.example.restservice.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobScheduler {
    @Autowired UserMapper userMapper;
//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelayJob() {
//        System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + " >>fixedDelay执行....");
//    }
//
//    @Scheduled(fixedRate = 5000)
//    public void fixedRateJob() {
//        System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + " >>fixedRate执行....");
//    }
//
//    @Scheduled(cron = "0 * * * * ?")
//    public void cronJob() {
//        System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + " >>cron执行....");
//    }

    @Scheduled(cron = "0 0 5 * * ?")
    public void payspend() {
//        System.out.print("PAYED");
        userMapper.payUser();
        userMapper.spendUser();
    }

    @Scheduled(cron = "0 0 1,10,11,14,20 * * ?")
    public void aiAction() {
//        System.out.print("PAYED");
        int userNum = 2;
        List<String> randusers = userMapper.randuser(userNum);
//        System.out.print(randusers);
        for(int i=0; i<userNum; i+=1) {
            userMapper.aiAddCredit(randusers.get(i));
        }
    }

}