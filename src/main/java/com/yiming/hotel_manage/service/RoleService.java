package com.yiming.hotel_manage.service;

import com.yiming.hotel_manage.pojo.Role;

import java.util.List;

public interface RoleService {

    List<Role> listRolesByUserId(Integer adminAccount);
}
