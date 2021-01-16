package com.yiming.hotel_manage.service.impl;

import com.yiming.hotel_manage.mapper.CheckOrderMapper;
import com.yiming.hotel_manage.pojo.CheckOrder;
import com.yiming.hotel_manage.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    private CheckOrderMapper checkOrderMapper;
    @Override
    public List<CheckOrder> getAllCheckOrder() {
        return checkOrderMapper.getAllCheckOrder();
    }

    @Override
    public CheckOrder getCheckOrderById(Integer id) {
        return checkOrderMapper.getCheckOrderById(id);
    }

    @Override
    public void updateCheckOrder(CheckOrder checkOrder) {

    }

    @Override
    public void deleteCheckOrder(Integer id) {
        checkOrderMapper.deleteCheckOrder(id);
    }

    @Override
    public void outCheckTime(Integer id, String time) {
        checkOrderMapper.outCheckTime(id, time);
    }


    @Override
    public void addCheckOrder(String userAccount,Integer roomId) {
        checkOrderMapper.addCheckOrder(userAccount,roomId);
    }

    @Override
    public List<CheckOrder> getCheckByUser(String id) {
        return checkOrderMapper.getCheckByUser(id);
    }
}
