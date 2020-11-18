package com.yiming.hotel_manage.mapper;

import com.yiming.hotel_manage.pojo.Admin;
import com.yiming.hotel_manage.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public interface UserMapper {
    @Select("select count(user_account) from tb_user_information")
    int getUserCount();

    Admin selectAdmin(String adminAccount);

    @Select("SELECT * FROM dbo.tb_user_information")
    List<User> getAllUser() ;

    @Select("SELECT * FROM dbo.tb_user_information WHERE user_account=#{id}")
    User getUserById(String id);

    @Update("UPDATE dbo.tb_user_information SET user_sfz=#{userSfz},user_name=#{userName},user_sex=#{userSex},user_age=#{userAge},user_tel=#{userTel} WHERE user_account=#{userAccount} ")
    void updateUser(User user);

    @Delete("DELETE dbo.tb_user_information WHERE user_account=#{id}")
    void deleteUser(String id);


    void addUser(User user);

    @Select("SELECT * FROM dbo.tb_user_information WHERE user_name=#{name}")
    User getUserInfo(String name);
}
