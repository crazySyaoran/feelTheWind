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
import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Objects;

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

        UserAction actedUA = new UserAction(session.getAttribute("loginUser").toString(), mealtype, "2020-05-04");
        List<String> actionid = actionMapper.actedAction(actedUA);
        if (actionid.size() == 0) {
            UserAction meal = new UserAction(session.getAttribute("loginUser").toString(),
                    mealtype,(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date),
                    addend,"");
            actionMapper.save(meal);
            session.setAttribute("actionMsg", "success");
        } else {
            session.setAttribute("actionMsg", "alreadyMealed");
        }
        return "redirect:/index";
    }

    @RequestMapping(value="/sleep")
    public String sleepAction(HttpSession session) throws Exception{

        UserAction sleep = new UserAction(session.getAttribute("loginUser").toString(),
                "sleep",(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()),
                -1,"");
        actionMapper.save(sleep);
        session.setAttribute("actionMsg", "success");

        return "redirect:/index";
    }

    @RequestMapping(value="/getup")
    public String getUpAction(HttpSession session) throws Exception{

        UserAction getup = new UserAction(session.getAttribute("loginUser").toString(),
                "getup",(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()),
                -1,"");
        actionMapper.save(getup);
        session.setAttribute("actionMsg", "success");

        return "redirect:/index";
    }


}