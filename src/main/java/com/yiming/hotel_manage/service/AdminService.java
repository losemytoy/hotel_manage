package com.yiming.hotel_manage.service;

import com.yiming.hotel_manage.pojo.Admin;

import java.util.List;

public interface AdminService {

    Admin selectAdmin(String adminAccount);

    List<Admin> getAllAdminers() ;

    Admin getAdminById(Integer id);

    void updateAdmin(Admin admin);

    void deleteAdmin(Integer id);

    void addAdmin(Admin admin);

    int getEmpCount(String type);

    int getUserCount();

    List<Admin> getEmpInfo(String name);

    List<String> getAllPerms();

    List<String> getAdminPerms(Integer adminAccount);

}
