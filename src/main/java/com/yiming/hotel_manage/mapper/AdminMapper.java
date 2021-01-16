package com.yiming.hotel_manage.mapper;

import com.yiming.hotel_manage.pojo.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {

    @Select("select * from tb_adminer where admin_account=#{adminAccount}")
    Admin selectAdmin(String adminAccount);

    @Select("select * from tb_adminer")
    List<Admin> getAllAdminers();

    @Select("select * from tb_adminer where admin_account=#{id}")
    Admin getAdminById(Integer id);

    @Update("update tb_adminer set admin_name=#{adminName},admin_pwd=#{adminPwd},admin_gender=#{adminGender},admin_join=#{adminJoin},admin_type=#{adminType} where admin_account=#{adminAccount}")
    void updateAdmin(Admin admin);

    @Delete("delete from tb_adminer where admin_account=#{id}")
    void deleteAdmin(Integer id);

    @Insert("insert into tb_adminer(admin_name,admin_pwd,admin_gender,admin_join,admin_type) values(#{adminName},#{adminPwd},#{adminGender},#{adminJoin},#{adminType})")
    void addAdmin(Admin admin);

    @Select("select count(admin_account) from tb_adminer where admin_type=#{type}")
    int getEmpCount(String type);

    @Select("select * from tb_adminer where admin_name like '%${name}%' ")
    List<Admin> getEmpInfo(String name);

    @Select("select * from tb_permission")
    List<String> getAllPerms();

    @Select("SELECT dbo.tb_permission.permission_code FROM dbo.tb_permission \n" +
            "INNER JOIN dbo.tb_role_permission ON tb_role_permission.permission_id = tb_permission.permission_id\n" +
            "INNER JOIN dbo.tb_user_role ON tb_user_role.role_id = tb_role_permission.role_id\n" +
            "WHERE dbo.tb_user_role.user_account = #{adminAccount}")
    List<String> getAdminPerms(Integer adminAccount);
}
