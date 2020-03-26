package com.user.app.controller;

import com.user.app.utils.HttpClientUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Authod:zeng
 * @Date: 2020/3/5 14:12
 * @Version: 0.0.1
 * 个人中心
 */
@Controller
@RequestMapping(value = "/user")
public class UserCentreController {

    @RequestMapping(value = "/loadMessage",method = RequestMethod.GET)
    @ResponseBody
    public Object loadMessage()throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("first","china");
        map.put("second","japan");

        String url = "http://localhost:8016/sms/loginSmsCode";
        //发送短信验证码
        String response = HttpClientUtil.httpPostRequest(url, new HashMap<>());
        return map;
    }




}
