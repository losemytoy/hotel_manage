package com.yiming.hotel_manage.service.impl;

import com.yiming.hotel_manage.mapper.RoomMapper;
import com.yiming.hotel_manage.pojo.Room;
import com.yiming.hotel_manage.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public int getRoomCount() {
        return roomMapper.getRoomCount();
    }

    @Override
    public int getRoomCountByType(String type) {
        return roomMapper.getRoomCountByType(type);
    }

    @Override
    public List<Room> getAllRoom() {
        return roomMapper.getAllRoom();
    }

    @Override
    public Room getRoomById(Integer id) {
        return roomMapper.getRoomById(id);
    }

    @Override
    public void updateRoom(Room room) {
        roomMapper.updateRoom(room);
    }

    @Override
    public void deleteRoom(Integer id) {
        roomMapper.deleteRoom(id);
    }

    @Override
    public void addRoom(Room room) {
        roomMapper.addRoom(room);
    }

    @Override
    public void resRoom(Integer id, String account) {
        roomMapper.resRoom(id,account);
    }
}
