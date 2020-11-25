package com.yiming.hotel_manage.mapper;

import com.yiming.hotel_manage.pojo.CheckOrder;
import com.yiming.hotel_manage.pojo.ReserveOrder;
import com.yiming.hotel_manage.service.ReserveService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResOrderMapper {
    @Select("select * from tb_room_reserve")
    List<ReserveOrder> getAllResOrder();

    @Delete("delete from tb_room_reserve where reserve_id=#{id}")
    void deleteResOrder(Integer id);

    @Select("select * from tb_room_reserve where reserve_id=#{id}")
    ReserveOrder getResOrderById(Integer id);

    @Select("select * from tb_room_reserve where user_account=#{id}")
    List<ReserveOrder> getResByUser(String id);

    @Delete("delete from tb_room_reserve where room_id=#{id}")
    void deleteResOrderByRoom(Integer id);
}
