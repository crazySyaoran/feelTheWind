package com.example.restservice.controller;


import com.example.restservice.mapper.PasswordMapper;
import com.example.restservice.mapper.UserMapper;
import com.example.restservice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired PasswordMapper passwordMapper;
    @Autowired UserMapper userMapper;

    @PostMapping(value = "/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session){

        String password_T = passwordMapper.getPassword(username);

        if(password_T == null){
            session.setAttribute("loginMsg", "signInFailed");
            return  "redirect:/login";
        }

        if(!StringUtils.isEmpty(username) && password_T.equals(password)){
            //登陆成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser",username);
            session.setAttribute("loginMsg", "");
            session.setAttribute("signupMsg","");

//            map.put("msg", "");
            return "redirect:/";
        }else{
            //登陆失败
//            map.put("msg", "用户名密码错误");
//            System.out.println("signInFailed");
            session.setAttribute("loginMsg", "signInFailed");
            return  "redirect:/login";
        }
    }

    @GetMapping("/")
    public String preIndex(HttpSession session, Model m){
        session.setAttribute("actionMsg","");
        session.setAttribute("signupMsg","");
        session.setAttribute("loginMsg","");

        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(HttpSession session, Model m){
//        System.out.print(session.getAttribute("loginUser").toString());
        User user = userMapper.getUser(session.getAttribute("loginUser").toString());
//        System.out.println(user.getUsername()+user.getUsertype()+user.getCredit()+user.getCoin());
        session.setAttribute("user",userMapper.getUser(session.getAttribute("loginUser").toString()));
        m.addAttribute("user", user);
        int level = 1 + (int)(Math.log(user.getCredit()+1) / Math.log(2));
        int credit_left = (2 << (level-1)) - 1 - user.getCredit();
        m.addAttribute("level", level);
        m.addAttribute("credit_left", credit_left);

        // 要注意 如果不满k个这里会炸
        List<User> topUsers = userMapper.getTopKUsers(3);
        m.addAttribute("topUsers", topUsers);

        return "index";
    }

    @GetMapping("/login")
    public String login(HttpSession session){
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginUser");
//        System.out.println(session.getAttribute("loginUser"));
        return "redirect:/";
    }

    @GetMapping("/post/help")
    public String posttemp(HttpSession session){
        return "post/help";
    }

}
