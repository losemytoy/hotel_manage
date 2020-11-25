package com.yiming.hotel_manage.mapper;

import com.yiming.hotel_manage.pojo.CheckOrder;
import com.yiming.hotel_manage.pojo.Room;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckOrderMapper {
    @Select("select * from tb_room_check")
    List<CheckOrder> getAllCheckOrder();

    @Delete("delete from tb_room_check where check_id=#{id}")
    void deleteCheckOrder(Integer id);

    @Select("select * from tb_room_check where check_id=#{id}")
    CheckOrder getCheckOrderById(Integer id);

    @Select("select * from tb_room_check where user_account=#{id}")
    List<CheckOrder> getCheckByUser(String id);

    @Insert("insert tb_room_check(user_account,room_id) values(#{userAccount},#{roomId})")
    void addCheckOrder(String userAccount,Integer roomId);

}
