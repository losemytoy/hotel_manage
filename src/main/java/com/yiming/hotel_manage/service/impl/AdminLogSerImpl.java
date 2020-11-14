package com.yiming.hotel_manage.service.impl;

import com.yiming.hotel_manage.pojo.Admin;
import com.yiming.hotel_manage.service.AdminLogService;
import com.yiming.hotel_manage.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminLogSerImpl implements AdminLogService {

    @Autowired
    private AdminService adminService;



    @Override
    public Admin getAdminByAccount(String adminAccount) {
        Admin admin = adminService.selectAdmin(adminAccount);
        return admin;
    }
}
