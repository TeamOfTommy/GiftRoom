package com.giftroom.dao;

import com.giftroom.model.User;


/**
 * Created by tommy on 2017/10/22.
 */

public interface IUserDao {
    //根据用户ID查询用户信息
    public User selectUser(String telnumber);
    //增加用户信息
    public void addUser(User user);
    //删除用户信息
    public void deleteUser(String telnumber);
    //修改用户信息
    public void updateUser(User user);
    //用户登陆信息check
    public User checkUser(User user);
}
