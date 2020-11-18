package com.yiming.hotel_manage.service;

import com.yiming.hotel_manage.pojo.Admin;
import com.yiming.hotel_manage.pojo.Room;
import com.yiming.hotel_manage.pojo.User;

import java.util.List;

public interface UserService {

    Admin selectAdmin(String adminAccount);

    List<User> getAllUser() ;

    User getUserById(String id);

    void updateUser(User User);

    void deleteUser(String id);

    void addUser(User user);

    int getUserCount();

    User getUserInfo(String name);
}
