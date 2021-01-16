package com.yiming.hotel_manage.pojo;

import java.time.LocalDateTime;
import java.util.Date;

public class CheckOrder {
    private String checkId;
    private String userAccount;
    private Integer roomId;
    private String checkTime;
    private String checkOutTime;


    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    @Override
    public String toString() {
        return "CheckOrder{" +
                "checkId='" + checkId + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", roomId=" + roomId +
                ", checkTime='" + checkTime + '\'' +
                ", checkOutTime=" + checkOutTime +
                '}';
    }
}
