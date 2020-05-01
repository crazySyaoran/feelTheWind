package com.example.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RestServiceApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);  //自动加载controller(用于接受用户请求) 和 service
    }

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder
    ){
        return builder.sources(this.getClass());
    }

}
