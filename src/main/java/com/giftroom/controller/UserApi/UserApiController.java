package com.giftroom.controller.UserApi;

import com.giftroom.Exception.Code;
import com.giftroom.Jsms.IJsmsService;
import com.giftroom.controller.BaseController;
import com.giftroom.dao.IUserDao;
import com.giftroom.model.User;
import com.giftroom.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tommy on 2017/10/22.
 */

@Controller
@RequestMapping("userapi")
public class UserApiController extends BaseController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IJsmsService jsmsService;

    private final static Logger logger = LoggerFactory.getLogger(UserApiController.class);

    @RequestMapping(value = "/user/reg/{telnumber}.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> reg(HttpServletRequest request, HttpServletResponse response,
                                   @PathVariable("telnumber") String telnumber,
                                   @RequestParam("nickname") String nickname,
                                   @RequestParam("password") String password,
                                   @RequestParam("code") String code,
                                   @RequestParam("msgId") String msgId) {
        try{
            User isExistUser = userService.selectUser(telnumber);
            if(isExistUser != null) {
                return renderErrorData(response, Code.IsUserExistError.getCode(), Code.IsUserExistError.getMessage());
            }
            if(!jsmsService.SendValidSMSCode(msgId, code)){
                return renderErrorData(response, Code.SmsCodeError.getCode(), Code.SmsCodeError.getMessage());
            }
            User user = new User(nickname, password, telnumber);
            userService.addUser(user);
            return renderData(response, user);
        }catch (Exception e){
            logger.error("user reg error:\n", e);
            return renderErrorData(response, Code.SeverErrorCode.getCode(), e.getMessage());
        }

    }

    @RequestMapping("/user/login/{telnumber}.do")
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response,
                                     @PathVariable("telnumber") String telnumber,
                                     @RequestParam("password") String password) {
        try{
            User user = new User();
            user.setTelnumber(telnumber);
            user.setPassword(password);
            User queryUser = userService.checkUser(user);
            return renderData(response, queryUser);
        }catch (Exception e){
            logger.error("user login error:\n", e);
            return renderErrorData(response, Code.SeverErrorCode.getCode(), e.getMessage());
        }

    }

    @RequestMapping("/user/smscode/send/{telnumber}.do")
    @ResponseBody
    public Map<String, Object> sendSMSCode(HttpServletRequest request, HttpServletResponse response,
                                          @PathVariable("telnumber") String telnumber){
        try{
            String msgId = jsmsService.sendSMSCode(telnumber);
            Map<String, String> map = new HashMap<String, String>();
            map.put("msgId", msgId);
            return renderData(response, map);
        }catch (Exception e){
            logger.error("user send smscode error:\n", e);
            return renderErrorData(response, Code.SeverErrorCode.getCode(), e.getMessage());
        }
    }
}
