package com.yiming.hotel_manage.service.impl;


import com.yiming.hotel_manage.mapper.ResOrderMapper;
import com.yiming.hotel_manage.pojo.ReserveOrder;
import com.yiming.hotel_manage.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReserveServiceImpl implements ReserveService {

    @Autowired
    private ResOrderMapper resOrderMapper;

    @Override
    public List<ReserveOrder> getAllResOrder() {
        return resOrderMapper.getAllResOrder();
    }

    @Override
    public ReserveOrder getResOrderById(Integer id) {
        return resOrderMapper.getResOrderById(id);
    }

    @Override
    public void updateResOrder(ReserveOrder reserveOrder) {

    }

    @Override
    public void deleteResOrder(Integer id) {
        resOrderMapper.deleteResOrder(id);
    }

    @Override
    public void addResOrder(ReserveOrder reserveOrder) {

    }
}
