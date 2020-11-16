package com.yiming.hotel_manage.pojo;

public class CheckOrder {
    private String checkId;
    private String userAccount;
    private Integer roomId;
    private String checkTime;

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

    @Override
    public String toString() {
        return "CheckOrder{" +
                "reserveId='" + checkId + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", roomId=" + roomId +
                ", checkTime='" + checkTime + '\'' +
                '}';
    }
}
