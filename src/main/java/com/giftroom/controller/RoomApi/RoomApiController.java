package com.giftroom.controller.RoomApi;

import com.giftroom.Exception.Code;
import com.giftroom.controller.BaseController;
import com.giftroom.model.Room;
import com.giftroom.service.IRoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by tommy on 2017/10/22.
 */
@Controller
@RequestMapping("roomapi")
public class RoomApiController extends BaseController{

    private final static Logger logger = LoggerFactory.getLogger(RoomApiController.class);

    @Autowired
    private IRoomService roomService;

    @RequestMapping(value = "/room/add/{roomnum}.do", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> reg(HttpServletRequest request, HttpServletResponse response,
                                   @PathVariable("roomnum") String roomNum,
                                   @RequestParam(value = "roomname") String roomName,
                                   @RequestParam(value = "roompic") String roomPic,
                                   @RequestParam(value = "roomonlinenum") String roomOnlineNum) {
        try{

            return renderData(response, null);
        }catch (Exception e){
            logger.error("user reg error:\n", e);
            return renderErrorData(response, Code.SeverErrorCode.getCode(), e.getMessage());
        }

    }

    @RequestMapping(value = "/room/getall.do", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAll(HttpServletRequest request, HttpServletResponse response) {
        try{
            List<Room> rooms = roomService.getAll();
            return renderData(response, rooms);
        }catch (Exception e){
            logger.error("user reg error:\n", e);
            return renderErrorData(response, Code.SeverErrorCode.getCode(), e.getMessage());
        }

    }

}
