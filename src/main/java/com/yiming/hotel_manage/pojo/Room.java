package com.yiming.hotel_manage.pojo;

public class Room {
    private Integer roomId;
    private String roomPrice;
    private String roomBedNum;
    private String roomStat;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(String roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getRoomBedNum() {
        return roomBedNum;
    }

    public void setRoomBedNum(String roomBedNum) {
        this.roomBedNum = roomBedNum;
    }

    public String getRoomStat() {
        return roomStat;
    }

    public void setRoomStat(String roomStat) {
        this.roomStat = roomStat;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomPrice='" + roomPrice + '\'' +
                ", roomBedNum='" + roomBedNum + '\'' +
                ", roomStat='" + roomStat + '\'' +
                '}';
    }
}
