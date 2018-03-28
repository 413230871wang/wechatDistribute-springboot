package com.example.demo.controller;

import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;
import com.example.demo.utils.IpUtils;
import com.example.demo.utils.Md5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lay on 2018/3/21.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BaseController{
    Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Resource(name = "adminService")
    private AdminService adminService;

    @RequestMapping(value = "/login.bl")
    public ModelAndView login(String userName, String passWd, HttpServletRequest request) throws Exception{
        ModelAndView mav = super.getMav();
        //解码密码
        String psd = Md5Utils.getMD5Code(passWd,"");
        //创建一个Admin对象用于查询
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("userName",userName);
        paramMap.put("passWord",psd);
        //获取后台用户信息
        Admin admin = adminService.getAdminInfo(paramMap);
        //admin信息进行判断
        if(admin != null) {
            String ip = "";
            if (admin.getStatus() == 0) {
                mav.addObject("errorMsg", "该帐号已被禁用");
                mav.addObject("type", "error");
                mav.setViewName("admin/login");
                return mav;
            }else {
                admin.setLogincount(admin.getLogincount()+1);
                admin.setLastlogintime(new Date());
                try{
                    ip = IpUtils.getIpAddress(request);
                    admin.setLastloginip(ip);
                }catch(Exception e){
                    logger.error("获取请求地址ip失败");
                    e.printStackTrace();
                }
                //修改用户信息
                adminService.updateAdminInfo(admin);
                mav.addObject("admin",admin);
                mav.setViewName("admin/index");
                return mav;
            }
        }else{
            mav.addObject("errorMsg", "用户名或者密码错误");
            mav.addObject("type", "error");
            mav.setViewName("admin/login");
            return mav;
        }
    }
}
