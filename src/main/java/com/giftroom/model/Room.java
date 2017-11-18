package com.giftroom.model;

/**
 * Created by tommy on 2017/11/5.
 */
public class Room {

    private Integer id;

    private String num;

    private String name;

    private String picture;

    private String onlinenum;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getOnlinenum() {
        return onlinenum;
    }

    public void setOnlinenum(String onlinenum) {
        this.onlinenum = onlinenum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
