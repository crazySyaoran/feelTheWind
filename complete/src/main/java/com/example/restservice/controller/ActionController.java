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
//        System.out.println(session.getAttribute("loginUser"));
//        return "redirect:index";
//        System.out.print((new SimpleDateFormat("yyyyMMddhhmmss")).format(new Date()));
        Date date = new Date();
        int hournow = Integer.parseInt((new SimpleDateFormat("HH")).format(date));
        String mealtype = hournow<10?"breakfast" : hournow>15?"supper" : "lunch";

        UserAction meal = new UserAction(session.getAttribute("loginUser").toString(),
                mealtype,(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date),
                1,"");

        actionMapper.save(meal);
        session.setAttribute("actionMsg", "success");

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