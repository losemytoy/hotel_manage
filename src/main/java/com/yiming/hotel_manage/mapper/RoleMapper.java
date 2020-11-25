package com.yiming.hotel_manage.mapper;

import com.yiming.hotel_manage.pojo.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {


    @Select("SELECT dbo.tb_role.* FROM dbo.tb_role\n" +
            "INNER JOIN dbo.tb_user_role ON tb_user_role.role_id = tb_role.role_id\n" +
            "WHERE dbo.tb_user_role.user_account=#{adminAccount}")
    List<Role> listRolesByUserId(Integer adminAccount);
}
