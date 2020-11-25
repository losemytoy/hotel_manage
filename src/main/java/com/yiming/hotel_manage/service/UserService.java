package com.yiming.hotel_manage.service;

import com.yiming.hotel_manage.pojo.Admin;
import com.yiming.hotel_manage.pojo.Room;
import com.yiming.hotel_manage.pojo.User;

import java.util.List;

public interface UserService {

    User selectUser(String userAccount);

    List<User> getAllUser() ;

    User getUserById(String id);

    void updateUser(User User);

    void deleteUser(String id);

    void addUser(User user);

    int getUserCount();

    List<User> getUserInfo(String name);
}
