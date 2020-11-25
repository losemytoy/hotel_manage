package com.yiming.hotel_manage.service.impl;

import com.yiming.hotel_manage.mapper.UserMapper;
import com.yiming.hotel_manage.pojo.Admin;
import com.yiming.hotel_manage.pojo.User;
import com.yiming.hotel_manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User selectUser(String userAccount) {
        return userMapper.selectUser(userAccount);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(String id) {
        userMapper.deleteUser(id);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public int getUserCount() {
        return 0;
    }

    @Override
    public List<User> getUserInfo(String name) {
        return userMapper.getUserInfo(name);
    }
}
