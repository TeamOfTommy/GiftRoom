package com.giftroom.dao.Impl;

import com.giftroom.dao.IRoomDao;
import com.giftroom.model.Room;
import com.giftroom.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by TommyYang on 2017/11/5.
 */
@Repository("roomDao")
public class RoomDaoImpl implements IRoomDao {

    //需要向dao实现类中注入sqlSessionFactory
    @Resource(name="sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;

    public List<Room> getAll() {
        SqlSession session = sqlSessionFactory.openSession();
        List<Room> rooms = session.selectList("com.giftroom.mapping.roomMapping.selectRooms");
        session.commit();
        session.close();
        return rooms;
    }

}
