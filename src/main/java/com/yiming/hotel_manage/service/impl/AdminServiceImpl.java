package com.yiming.hotel_manage.service.impl;

import com.yiming.hotel_manage.mapper.AdminMapper;
import com.yiming.hotel_manage.mapper.UserMapper;
import com.yiming.hotel_manage.pojo.Admin;
import com.yiming.hotel_manage.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Admin selectAdmin(String adminAccount) {
        return adminMapper.selectAdmin(adminAccount);
    }

    @Override
    public List<Admin> getAllAdminers() {
        return adminMapper.getAllAdminers();
    }

    @Override
    public Admin getAdminById(Integer id) {
        return adminMapper.getAdminById(id);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminMapper.updateAdmin(admin);
    }

    @Override
    public void deleteAdmin(Integer id) {
        adminMapper.deleteAdmin(id);
    }

    @Override
    public void addAdmin(Admin admin) {
        adminMapper.addAdmin(admin);
    }

    @Override
    public int getEmpCount(String type) {
        return adminMapper.getEmpCount(type);
    }

    @Override
    public int getUserCount() {
        return userMapper.getUserCount();
    }

    @Override
    public List<Admin> getEmpInfo(String name) {
        return adminMapper.getEmpInfo(name);
    }

    @Override
    public List<String> getAllPerms() {
        return adminMapper.getAllPerms();
    }

    @Override
    public List<String> getAdminPerms(Integer adminAccount) {
        return adminMapper.getAdminPerms(adminAccount);
    }


}
