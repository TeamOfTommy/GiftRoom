package com.giftroom.service.Impl;

import com.giftroom.dao.IUserDao;
import com.giftroom.model.User;
import com.giftroom.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.xml.ws.soap.Addressing;

/**
 * Created by tommy on 2017/10/22.
 */
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    @Qualifier("userDao")
    public IUserDao userDao;

    public User selectUser(String telnumber) {
        return userDao.selectUser(telnumber);
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public void deleteUser(String telnumber) {
        userDao.deleteUser(telnumber);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public User checkUser(User user) {
        return userDao.checkUser(user);
    }
}
