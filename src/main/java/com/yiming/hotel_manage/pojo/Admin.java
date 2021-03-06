package com.yiming.hotel_manage.pojo;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Admin implements Serializable {

    //系统最高权限
    public static final int SUPER_ADMIN = 0;

    private Integer adminAccount;
    private String adminName;
    private String adminPwd;
    private Integer adminGender;
    private Date adminJoin;
    private String adminType;
    private Set<Role> roles;

    public Integer getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(Integer adminAccount) {
        this.adminAccount = adminAccount;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public Integer getAdminGender() {
        return adminGender;
    }

    public void setAdminGender(Integer adminGender) {
        this.adminGender = adminGender;
    }

    public Date getAdminJoin() {
        return adminJoin;
    }

    public void setAdminJoin(Date adminJoin) {
        this.adminJoin = adminJoin;
    }

    public String getAdminType() {
        return adminType;
    }

    public void setAdminType(String adminType) {
        this.adminType = adminType;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminAccount=" + adminAccount +
                ", adminName='" + adminName + '\'' +
                ", adminPwd='" + adminPwd + '\'' +
                ", adminGender=" + adminGender +
                ", adminJoin=" + adminJoin +
                ", adminType=" + adminType +
                '}';
    }
}
