package com.yiming.hotel_manage.service.impl;

import com.yiming.hotel_manage.mapper.RoleMapper;
import com.yiming.hotel_manage.pojo.Role;
import com.yiming.hotel_manage.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public List<Role> listRolesByUserId(Integer adminAccount) {
        return roleMapper.listRolesByUserId(adminAccount);
    }
}
