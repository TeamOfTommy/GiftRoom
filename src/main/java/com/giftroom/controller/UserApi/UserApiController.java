package com.giftroom.controller.UserApi;

import com.giftroom.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("userapi")
public class UserApiController extends BaseController{

    @RequestMapping("/user/reg")
    @ResponseBody
    public Map<String, Object> reg(HttpServletRequest request, HttpServletResponse response,
                                   @RequestParam("name") String name){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("a","b");
        return map;
    }

}
