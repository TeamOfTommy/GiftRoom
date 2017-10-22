package com.giftroom.service;

import com.giftroom.model.User;

/**
 * Created by tommy on 2017/10/22.
 */

public interface IUserService {

    public User selectUser(String telnumber);

    public void addUser(User user);

    public void deleteUser(String telnumber);

    public void updateUser(User user);

}
