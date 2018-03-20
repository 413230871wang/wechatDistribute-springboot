package com.example.demo.controller;

import com.example.demo.bean.BookBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lay on 2018/3/20.
 */
@Controller
public class IndexController {
    @Value(value = "${books.author}")
    private String bookAuthor;
    @Value("${books.name}")
    private String bookName;
    @Value("${books.pinyin}")
    private String bookPinYin;

    @Autowired
    private BookBean bookBean;

    @RequestMapping("/index")
    public String index(){
        System.out.println("这是一个测试类");
        System.out.println("Hello Spring Boot! The BookName is "+bookName+";and Book Author is "+bookAuthor+";and Book PinYin is "+bookPinYin);
        System.out.println("Hello Spring Boot! The BookName is "+bookBean.getName()+";and Book Author is "+bookBean.getAuthor()+";and Book price is "+bookBean.getPrice());
        return "index";
    }
}
