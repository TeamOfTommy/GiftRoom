package com.giftroom.model;

/**
 * Created by tommy on 2017/11/5.
 */
public class Room {

    private Integer id;

    private String roomNum;

    private String roomName;

    private String roomPic;

    private String roomOnlineNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomPic() {
        return roomPic;
    }

    public void setRoomPic(String roomPic) {
        this.roomPic = roomPic;
    }

    public String getRoomOnlineNum() {
        return roomOnlineNum;
    }

    public void setRoomOnlineNum(String roomOnlineNum) {
        this.roomOnlineNum = roomOnlineNum;
    }
}
