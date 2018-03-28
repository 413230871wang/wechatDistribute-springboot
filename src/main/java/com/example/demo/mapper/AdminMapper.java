package com.example.demo.mapper;

import com.example.demo.model.Admin;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository("adminMapper")
public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Admin record);

    public Admin getAdminInfo(Map<String,Object> map);

    public void updateAdminInfo(Admin admin);
}