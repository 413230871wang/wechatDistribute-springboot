package com.example.demo.service;

import com.example.demo.model.Admin;

import java.util.Map;

/**
 * Created by lay on 2018/3/21.
 */
public interface AdminService {
    public Admin getAdminInfo(Map<String,Object> map) throws Exception;

    public void updateAdminInfo(Admin admin) throws Exception;
}
