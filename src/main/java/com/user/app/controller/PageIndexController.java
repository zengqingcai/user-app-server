package com.user.app.controller;

import com.user.app.config.RedisUtil;
import com.user.app.utils.HttpClientUtil;
import com.user.app.utils.VerifyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @Authod:zeng
 * @Date: 2020/3/3 15:56
 * @Version: 0.0.1
 * 所有页面的跳转
 */
@Controller
@RequestMapping(value = "/")
public class PageIndexController {

    @Autowired
    private RedisUtil redisUtil;


    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home(){
        return "home";
    }


    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String toRegister(){
        return "register";
    }

    //获取短信验证码
    @RequestMapping(value = "getSmsCode", method = RequestMethod.GET)
    @ResponseBody
    public Object getSmsCode(@RequestBody String phone)throws Exception{
        String url = "http://localhost:8016/sms/getCode";
        //发送短信验证码
        Map<String,String> params = new HashMap<>();
        params.put("buss","login");
        String response = HttpClientUtil.httpPostRequest(url, params);
        redisUtil.set(response+phone,response,180);
        return "register";
    }

    @RequestMapping(value = "doRegister", method = RequestMethod.POST)
    @ResponseBody
    public Object doRegister()throws Exception{

        return "register";
    }


    @RequestMapping(value = "userCentre")
    public String userCentre(){
        return "user/user-centre";
    }

    @RequestMapping(value = "userMessage")
    public String userMessage(){
        return "user/user-centre";
    }

    @RequestMapping(value = "userSetting")
    public String userSetting(){
        return "user/user-centre";
    }

}
