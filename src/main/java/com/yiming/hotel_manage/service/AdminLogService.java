package com.yiming.hotel_manage.service;

import com.yiming.hotel_manage.pojo.Admin;

public interface AdminLogService {
    Admin getAdminByAccount(String AdminAccount) throws Exception;

}
