package com.yiming.hotel_manage.service.impl;

import com.yiming.hotel_manage.mapper.AdminMapper;
import com.yiming.hotel_manage.pojo.Admin;
import com.yiming.hotel_manage.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin selectAdmin(String adminAccount) {
        return adminMapper.selectAdmin(adminAccount);
    }
}
