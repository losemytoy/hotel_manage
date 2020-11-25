package com.yiming.hotel_manage.service;

import com.yiming.hotel_manage.pojo.CheckOrder;
import com.yiming.hotel_manage.pojo.ReserveOrder;
import com.yiming.hotel_manage.pojo.Room;

import java.util.List;

public interface CheckService {
    List<CheckOrder> getAllCheckOrder();

    CheckOrder getCheckOrderById(Integer id);

    void updateCheckOrder(CheckOrder checkOrder);

    void deleteCheckOrder(Integer id);

    void addCheckOrder(String userAccount,Integer roomId);

    List<CheckOrder> getCheckByUser(String id);
}
