package com.example.restservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FkController {

    @RequestMapping("/fk")
    public String hello(Model m) {
        m.addAttribute("name", "thymeleaf");
        return "fk";
    }
}
