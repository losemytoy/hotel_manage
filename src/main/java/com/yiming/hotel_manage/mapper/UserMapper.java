package com.yiming.hotel_manage.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface UserMapper {
    @Select("select count(user_account) from tb_user")
    int getUserCount();
}
