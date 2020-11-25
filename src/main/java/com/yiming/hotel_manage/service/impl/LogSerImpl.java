package com.yiming.hotel_manage.service.impl;

import com.yiming.hotel_manage.pojo.Admin;
import com.yiming.hotel_manage.pojo.User;
import com.yiming.hotel_manage.service.AdminService;
import com.yiming.hotel_manage.service.LogService;
import com.yiming.hotel_manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogSerImpl implements LogService {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @Override
    public Admin getAdminByAccount(String adminAccount) {
        Admin admin = adminService.selectAdmin(adminAccount);
        return admin;
    }

    @Override
    public User getUserByAccount(String userAccount) {
        User user = userService.selectUser(userAccount);
        return user;
    }

    public Boolean checkLogin(String userAccount,String userPwd){
        User user = userService.selectUser(userAccount);
        if (user != null && userPwd.equals(user.getUserPwd())){
            return true;
        }
        return null;
    }

}
