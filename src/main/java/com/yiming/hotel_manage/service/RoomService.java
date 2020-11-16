package com.yiming.hotel_manage.service;

import com.yiming.hotel_manage.pojo.Admin;
import com.yiming.hotel_manage.pojo.Room;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RoomService {
    int getRoomCount();

    int getRoomCountByType(String type);

    List<Room> getAllRoom();

    Room getRoomById(Integer id);

    void updateRoom(Room room);

    void deleteRoom(Integer id);

    void addRoom(Room room);
}
