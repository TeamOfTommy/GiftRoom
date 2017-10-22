package com.giftroom.dao.Impl;

import com.giftroom.dao.IUserDao;
import com.giftroom.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by tommy on 2017/10/22.
 */

@Repository("userDao")
public class UserDaoImpl implements IUserDao {

    //需要向dao实现类中注入sqlSessionFactory
    @Resource(name="sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;


    public User selectUser(String telnumber) {
        SqlSession session = sqlSessionFactory.openSession();
        User user = session.selectOne("com.giftroom.mapping.userMapping.selectUser", telnumber);
        session.commit();
        session.close();
        return user;
    }

    public void addUser(User user) {
        SqlSession session = sqlSessionFactory.openSession();
        session.insert("com.giftroom.mapping.userMapping.addUser", user);
        session.commit();
        session.close();
    }

    public void deleteUser(String telnumber) {
        SqlSession session = sqlSessionFactory.openSession();
        session.delete("com.giftroom.mapping.userMapping.deleteUser", telnumber);
        session.commit();
        session.close();
    }

    public void updateUser(User user) {
        SqlSession session = sqlSessionFactory.openSession();
        session.update("com.giftroom.mapping.userMapping.updateUser", user);
        session.commit();
        session.close();
    }

    public User checkUser(User user) {
        SqlSession session = sqlSessionFactory.openSession();
        User querydUser = session.selectOne("com.giftroom.mapping.userMapping.checkUser",user);
        session.commit();
        session.close();
        return querydUser;
    }
}
