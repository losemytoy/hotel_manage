package com.yiming.hotel_manage.mapper;

import com.yiming.hotel_manage.pojo.Admin;
import com.yiming.hotel_manage.pojo.Room;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomMapper {

    @Select("select count(room_id) from tb_room")
    int getRoomCount();

    @Select("select count(room_id) from tb_room where room_stat=#{type}")
    int getRoomCountByType(String type);

    @Select("select * from tb_room")
    List<Room> getAllRoom();

    @Select("select * from tb_room where room_id=#{id}")
    Room getRoomById(Integer id);

    @Update("update tb_room set room_price=#{roomPrice},room_bednum=#{roomBedNum} where room_id=#{roomId}")
    void updateRoom(Room room);

    @Delete("delete from tb_room where room_id=#{id}")
    void deleteRoom(Integer id);

    @Insert("insert tb_room(room_price,room_bednum,room_stat) values(#{roomPrice},#{roomBedNum},#{roomStat})")
    void addRoom(Room room);

    @Insert("insert tb_room_reserve(user_account,room_id) values(#{account},#{id})")
    void resRoom(Integer id,String account);
}
