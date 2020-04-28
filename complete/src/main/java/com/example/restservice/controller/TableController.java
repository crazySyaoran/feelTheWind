package com.example.restservice.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.restservice.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class TableController {

    @RequestMapping("/table")
    public String test(Model m) {
        String htmlContent = "<p style='color:red'> 红色文字</p>";
        Product currentProduct =new Product(5,"product e", 200);
        boolean testBoolean = true;

        List<Product> ps = new ArrayList<>();
        ps.add(new Product(1,"product a", 50));
        ps.add(new Product(2,"product b", 100));
        ps.add(new Product(3,"product c", 150));
        ps.add(new Product(4,"product d", 200));
        ps.add(currentProduct);
        ps.add(new Product(6,"product f", 200));
        ps.add(new Product(7,"product g", 200));

        m.addAttribute("ps", ps);
        m.addAttribute("htmlContent", htmlContent);
        m.addAttribute("currentProduct", currentProduct);
        m.addAttribute("testBoolean", testBoolean);

//        System.out.print(ps);

        return "table";
    }
}