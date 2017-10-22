package com.giftroom.controller.UserApi;

import com.giftroom.Jsms.IJsmsService;
import com.giftroom.controller.BaseController;
import com.giftroom.dao.IUserDao;
import com.giftroom.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tommy on 2017/10/22.
 */

@Controller
@RequestMapping("userapi")
public class UserApiController extends BaseController {

    @Autowired
    @Qualifier("userDao")
    private IUserDao userDao;
    @Autowired
    private IJsmsService jsmsService;

    @RequestMapping("/user/reg/{nickname}/{password}/{telnumber}.do")
    @ResponseBody
    public Map<String, Object> reg(HttpServletRequest request, HttpServletResponse response,
                                   @PathVariable("nickname") String nickname,
                                   @PathVariable("password") String password,
                                   @PathVariable("telnumber") String telnumber) {
        User user = new User(nickname, password, telnumber);
        jsmsService.sendValidSMSCode(telnumber);
        userDao.addUser(user);
        return renderData(response, user);
    }

    @RequestMapping("/user/login/{password}/{telnumber}.do")
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response,
                                     @PathVariable("telnumber") String telnumber,
                                     @PathVariable("password") String password) {
        User user = new User();
        user.setTelnumber(telnumber);
        user.setPassword(password);
        User queryUser = userDao.checkUser(user);
        return renderData(response, queryUser);
    }
}
