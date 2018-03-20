package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lay on 2018/3/20.
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        System.out.println("这是一个测试类");
        return "index";
    }
}
