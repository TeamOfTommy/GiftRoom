package com.giftroom.service.Impl;

import com.giftroom.dao.IRoomDao;
import com.giftroom.model.Room;
import com.giftroom.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TommyYang on 2017/11/5.
 */
@Service
public class RoomServiceImpl implements IRoomService {

    @Autowired
    @Qualifier("roomDao")
    private IRoomDao roomDao;

    public List<Room> getAll() {
        return roomDao.getAll();
    }
}
