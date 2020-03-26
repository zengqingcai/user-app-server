package com.user.app.controller;

import com.user.common.model.CodeMsg;
import com.user.app.config.RedisUtil;
import com.user.app.model.TestUser2;
import com.user.app.model.news.News;
import com.user.app.model.user.UserBase;
import com.user.app.remote.UserAppFeignService;
import com.user.app.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
    public String home(ModelMap modelMap){
        modelMap.put("src1","/images/rd_icon.png");
        modelMap.put("title","today News");
        modelMap.put("aSrc","/title");

        News news = new News(1,"title1","America News");
        News news1 = new News(2,"title2","China News");
        News news2 = new News(3,"title3","今日头条");
        List<News> list = Arrays.asList(news,news1,news2);
        modelMap.put("list",list);
        return "home";
    }

    @RequestMapping(value = "title", method = RequestMethod.GET)
    public String title(ModelMap modelMap){

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

    @Autowired
    private UserAppFeignService userAppFeignService;


    @RequestMapping("doRegister")
    @ResponseBody
    public CodeMsg doRegister(@RequestBody TestUser2 user,HttpServletResponse response)throws Exception {
        //todo 还有短信业务
        UserBase userBase = new UserBase();
        userBase.setCode(user.getCode());
        CodeMsg codeMsg = userAppFeignService.saveUserBase(userBase);
        System.out.println(codeMsg.getCode());

        response.setHeader("token","token:"+user.getCode());
        return codeMsg;
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
