package com.yiming.hotel_manage.service;

import com.yiming.hotel_manage.pojo.CheckOrder;
import com.yiming.hotel_manage.pojo.ReserveOrder;
import com.yiming.hotel_manage.pojo.Room;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface CheckService {
    List<CheckOrder> getAllCheckOrder();

    CheckOrder getCheckOrderById(Integer id);

    void updateCheckOrder(CheckOrder checkOrder);

    void deleteCheckOrder(Integer id);

    void outCheckTime(Integer id,String time);

    void addCheckOrder(String userAccount,Integer roomId);

    List<CheckOrder> getCheckByUser(String id);
}
