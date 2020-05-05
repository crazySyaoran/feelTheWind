package com.example.restservice.controller;


import com.example.restservice.mapper.ActionMapper;
import com.example.restservice.mapper.PasswordMapper;
import com.example.restservice.mapper.UserMapper;
import com.example.restservice.pojo.User;
import com.example.restservice.pojo.UserAction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class ActionController {
    @Autowired ActionMapper actionMapper;
    @Autowired UserMapper userMapper;

    @RequestMapping("/listAction")
    public String listCategory(Model m,@RequestParam(value = "start", defaultValue = "0") int start,
                               @RequestParam(value = "size", defaultValue = "10") int size,
                               HttpSession session) throws Exception {
        PageHelper.startPage(start,size,"actionid desc");
        List<UserAction> userActionList = actionMapper.getUserAction(session.getAttribute("loginUser").toString());
        PageInfo<UserAction> userActionPage = new PageInfo<>(userActionList);
//        System.out.println(userActionPage.getList());
        m.addAttribute("userActionPage", userActionPage);
        return "listAction";
    }

    @RequestMapping(value="/meal")
    public String mealAction(HttpSession session) throws Exception{

        Date date = new Date();
        int hournow = Integer.parseInt((new SimpleDateFormat("HH")).format(date));
        int minutenow = Integer.parseInt((new SimpleDateFormat("mm")).format(date));
        float timenow = hournow + (float)minutenow/60f;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, -1);
        Date yesterday = c.getTime();

        String mealtype = timenow<10.5?"breakfast" : timenow>15.5?"supper" : "lunch";
        int addend = 0;

        // ----9:00----10:00----10:30----11:15----14:00----15:30----18:30----
        //   3       2        1   |    1        2        1   |    2        1

        if ("breakfast".equals(mealtype)) {
            addend = timenow<9?3 : timenow>10?1 : 2;
        }else if ("lunch".equals(mealtype)) {
            addend = timenow<11.25?1 : timenow>14?1 : 2;
        }else {
            addend = timenow<18.5?2 : 1;
        }

        UserAction actedUA = new UserAction(session.getAttribute("loginUser").toString(), mealtype,
                new SimpleDateFormat("yyyy-MM-dd").format(date));
        List<UserAction> actions = actionMapper.actedAction(actedUA);
        if (actions.size() == 0) {
            UserAction meal = new UserAction(session.getAttribute("loginUser").toString(),
                    mealtype,(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date),
                    addend,"");
            actionMapper.save(meal);
            actionMapper.addcredit(meal);
            session.setAttribute("actionMsg", "success");
            session.setAttribute("actionAddend", "+" + addend);
        } else {
            session.setAttribute("actionMsg", "alreadyMealed");
        }
        return "redirect:/index";
    }

    @RequestMapping(value="/sleep")
    public String sleepAction(HttpSession session) throws Exception{

        Date date = new Date();
        int hournow = Integer.parseInt((new SimpleDateFormat("HH")).format(date));
        int minutenow = Integer.parseInt((new SimpleDateFormat("mm")).format(date));
        float timenow = hournow + (float)minutenow/60f;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, -1);
        Date yesterday = c.getTime();

        // 0:00前睡觉是2分 否则1分
        int addend = timenow<5 ? 1 : 2;

        UserAction actedSleepToday = new UserAction(session.getAttribute("loginUser").toString(), "sleep",
                new SimpleDateFormat("yyyy-MM-dd").format(date));
        UserAction actedSleepYesterday = new UserAction(session.getAttribute("loginUser").toString(), "sleep",
                new SimpleDateFormat("yyyy-MM-dd").format(yesterday));

        if (5 < timenow &&  timenow < 19) {
            session.setAttribute("actionMsg", "fail_noInTime");
            return "redirect:/index";
        }

        if (timenow >= 19) {
            List<UserAction> actions = actionMapper.actedAction(actedSleepToday);
            Boolean flag = Boolean.TRUE;

            for (UserAction ua : actions) {
                String x = ua.getActiontime();
                if (Integer.parseInt(ua.getActiontime().substring(11,13)) >= 19) {
                    flag = Boolean.FALSE;
                    break;
                }
            }
            if (flag) {
                UserAction sleep = new UserAction(session.getAttribute("loginUser").toString(),
                        "sleep",(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()),
                        addend,"");
                actionMapper.save(sleep);
                actionMapper.addcredit(sleep);
                session.setAttribute("actionMsg", "success");
                session.setAttribute("actionAddend", "+" + addend);
            } else {
                session.setAttribute("actionMsg", "alreadySlept");
            }
        } else if (timenow <= 5) {
            List<UserAction> actionsToday = actionMapper.actedAction(actedSleepToday);
            List<UserAction> actionsYesterday = actionMapper.actedAction(actedSleepYesterday);
            Boolean flag = Boolean.TRUE;
            for (UserAction ua : actionsToday) {
                if (Integer.parseInt(ua.getActiontime().substring(11,13)) <= 5) {
                    flag = Boolean.FALSE;
                    break;
                }
            }
            for (UserAction ua : actionsYesterday) {
                if (Integer.parseInt(ua.getActiontime().substring(11,13)) >= 19) {
                    flag = Boolean.FALSE;
                    break;
                }
            }
            if (flag) {
                UserAction sleep = new UserAction(session.getAttribute("loginUser").toString(),
                        "sleep",(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()),
                        addend,"");
                session.setAttribute("actionMsg", "success");
                session.setAttribute("actionAddend", "+" + addend);
                actionMapper.save(sleep);
                actionMapper.addcredit(sleep);
            } else {
                session.setAttribute("actionMsg", "alreadySlept");
            }
        }
        return "redirect:/index";
    }

    @RequestMapping(value="/getup")
    public String getUpAction(HttpSession session) throws Exception{

        Date date = new Date();
        int hournow = Integer.parseInt((new SimpleDateFormat("HH")).format(date));
        int minutenow = Integer.parseInt((new SimpleDateFormat("mm")).format(date));
        float timenow = hournow + (float)minutenow/60f;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, -1);
        Date yesterday = c.getTime();

        int addend =  timenow<8.5?3 : timenow>9.5?1 : 2;


        if (timenow < 5 || 19 < timenow) {
            session.setAttribute("actionMsg", "fail_noInTime");
            return "redirect:/index";
        }

        UserAction actedUA = new UserAction(session.getAttribute("loginUser").toString(), "getup",
                new SimpleDateFormat("yyyy-MM-dd").format(date));
        List<UserAction> actions = actionMapper.actedAction(actedUA);
        if (actions.size() == 0) {

            UserAction getup = new UserAction(session.getAttribute("loginUser").toString(),
                    "getup",(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()),
                    addend,"");
            actionMapper.save(getup);
            actionMapper.addcredit(getup);
            session.setAttribute("actionMsg", "success");
        } else {
            session.setAttribute("actionMsg", "alreadyGotUp");
        }

        return "redirect:/index";
    }


}