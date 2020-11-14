package com.yiming.hotel_manage.pojo;


import java.io.Serializable;
import java.util.Set;

/**
 * 角色对应实体类
 */

public class Role implements Serializable {
    private Integer id; // 编号
    private String name; // 角色标识程序中判断使用,如"admin",这个是唯一的:
    private String description; // 角色描述,UI界面显示使用
    private Set<Permission> permissions;
    private Set<Admin> userInfos;// 一个角色对应多个用户

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Admin> getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(Set<Admin> userInfos) {
        this.userInfos = userInfos;
    }
}
