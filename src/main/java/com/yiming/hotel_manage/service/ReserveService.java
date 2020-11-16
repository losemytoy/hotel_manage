package com.yiming.hotel_manage.service;

import com.yiming.hotel_manage.pojo.CheckOrder;
import com.yiming.hotel_manage.pojo.ReserveOrder;

import java.util.List;

public interface ReserveService {
    List<ReserveOrder> getAllResOrder();

    ReserveOrder getResOrderById(Integer id);

    void updateResOrder(ReserveOrder reserveOrder);

    void deleteResOrder(Integer id);

    void addResOrder(ReserveOrder reserveOrder);
}
