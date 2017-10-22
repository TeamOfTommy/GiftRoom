package com.giftroom.model;

import java.util.Date;

/**
 * Created by tommy on 2017/10/22.
 */

public class User {
    private Integer id;
    private String name;
    private String nickname;
    private String realName;
    private String password;
    private String gender;
    private String telnumber;
    private Integer userType;
    private Integer userStataus;
    private Date regTime;
    private Date modifyTime;

    public User() {
    }

    public User(String nickname, String password, String telnumber) {
        this.nickname = nickname;
        this.password = password;
        this.telnumber = telnumber;
    }

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getUserStataus() {
        return userStataus;
    }

    public void setUserStataus(Integer userStataus) {
        this.userStataus = userStataus;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickname + '\'' +
                ", realName='" + realName + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", telnumber='" + telnumber + '\'' +
                ", userType=" + userType +
                ", userStataus=" + userStataus +
                ", regTime=" + regTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
