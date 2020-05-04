package com.example.restservice.controller;


import com.example.restservice.mapper.PasswordMapper;
import com.example.restservice.mapper.UserMapper;
import com.example.restservice.pojo.User;
import com.example.restservice.pojo.UserAction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired PasswordMapper passwordMapper;
    @Autowired UserMapper userMapper;

    @RequestMapping("/userRank")
    public String listCategory(Model m,@RequestParam(value = "start", defaultValue = "0") int start,
                               @RequestParam(value = "size", defaultValue = "10") int size,
                               HttpSession session) throws Exception {
        PageHelper.startPage(start,size,"credit desc");
        List<User> userList = userMapper.ranklist();
        for(int i = 0; i < userList.size(); i+=1) {
            userList.get(i).setRank(i+1);
        }

        PageInfo<User> userRankPage = new PageInfo<>(userList);
//        System.out.println(userRankPage.getList());
        m.addAttribute("userRankPage", userRankPage);
        return "listUser";
    }


}
