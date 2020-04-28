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
import java.util.Map;

@Controller
public class LoginController {
    @Autowired PasswordMapper passwordMapper;
    @Autowired UserMapper userMapper;

    @PostMapping(value = "/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){

        String password_T = passwordMapper.getPassword(username);

        if(!StringUtils.isEmpty(username) && password_T.equals(password)){
            //登陆成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser",username);
            return "redirect:/index";
        }else{
            //登陆失败
            map.put("msg","用户名密码错误");
            return  "login";
        }
    }

//    @GetMapping("/")
//    public String entry(){
//        return "index";
//    }

    @GetMapping({"/index", "/"})
    public String index(HttpSession session, Model m){
//        System.out.print(session.getAttribute("loginUser").toString());
        User user = userMapper.getUser(session.getAttribute("loginUser").toString());
//        System.out.println(user.getUsername()+user.getUsertype()+user.getCredit());

        session.setAttribute("user",userMapper.getUser(session.getAttribute("loginUser").toString()));
        m.addAttribute("user", user);

        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginUser");
//        System.out.println(session.getAttribute("loginUser"));
        return "redirect:login";
    }


}
