package com.example.demo.controller;

import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lay on 2018/3/21.
 */
public class BaseController {
    //公共类 获取ModelAndView
    public ModelAndView getMav(){
        ModelAndView mav = new ModelAndView();
        return mav;
    }
}
