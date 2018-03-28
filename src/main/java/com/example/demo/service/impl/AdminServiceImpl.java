package com.example.demo.service.impl;

import com.example.demo.mapper.AdminMapper;
import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by lay on 2018/3/21.
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource(name = "adminMapper")
    private AdminMapper adminMapper;

    @Override
    public Admin getAdminInfo(Map<String,Object> map) throws Exception {
        Admin admin = adminMapper.getAdminInfo(map);
        return admin;
    }

    @Override
    public void updateAdminInfo(Admin admin) throws Exception {
        adminMapper.updateAdminInfo(admin);
    }
}
