package com.fandikang.demo24B.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Testcontroller {

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        System.out.println("Hello World");
        return "Hello World";
    }
}