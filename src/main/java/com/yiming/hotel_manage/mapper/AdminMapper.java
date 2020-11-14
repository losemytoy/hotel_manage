package com.yiming.hotel_manage.mapper;

import com.yiming.hotel_manage.pojo.Admin;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {

    @Select("select * from tb_adminer where admin_account=#{adminAccount}")
    Admin selectAdmin(String adminAccount);
}
