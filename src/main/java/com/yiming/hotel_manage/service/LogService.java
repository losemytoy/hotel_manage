package com.yiming.hotel_manage.service;

import com.yiming.hotel_manage.pojo.Admin;
import com.yiming.hotel_manage.pojo.User;

import java.util.List;

public interface LogService {
    Admin getAdminByAccount(String AdminAccount) throws Exception;

    User getUserByAccount(String userAccount);

    Boolean checkLogin(String loginId, String password);
}
