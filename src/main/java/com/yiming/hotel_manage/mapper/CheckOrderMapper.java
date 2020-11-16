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

}
