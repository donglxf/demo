package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/login")
    public String hello(){
        return "login";
    }

    @RequestMapping("/hello")
    public String hellos(){
        return "hello";
    }

    @RequestMapping("/indexDev")
    public String indexDev(){
        return "indexDev";
    }
}
