package com.example.restservice.controller;


import com.example.restservice.mapper.PasswordMapper;
import com.example.restservice.mapper.UserMapper;
import com.example.restservice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class SignupController {
    @Autowired PasswordMapper passwordMapper;
    @Autowired UserMapper userMapper;

    @RequestMapping(value = "/signup")
        public String register(HttpSession session){
            return "signup";
        }


    @PostMapping(value = "/signup")
    public String signin(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam("password2") String password2,
                         @RequestParam("invitationCode") String invitationCode,
                         @RequestParam("email") String email,
                         HttpSession session, Model m){

        if(userMapper.getUser(username) != null){
            session.setAttribute("signupMsg", "userExist");
            return "redirect:/signup";
        }

        if(! password.equals(password2)){
            session.setAttribute("signupMsg", "differentPassword");
            return "redirect:/signup";
        }

        if(! "qindan233".equals(invitationCode)){
            session.setAttribute("signupMsg", "invalidInvitationCode");
            return "redirect:/signup";
        }

        if(password.length() < 8){
            session.setAttribute("signupMsg", "tooShortPassword");
            return "redirect:/signup";
        }

        userMapper.addUser(new User(username, password, "user", 0, email));
        session.setAttribute("signupMsg", "success");
        return "redirect:/login";
    }

}
