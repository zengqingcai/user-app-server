package com.user.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/test")
public class TestController {

    @Value("${test.name}")
    private String name;

    @Value("${boot.app}")
    private String app;


    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    @ResponseBody
    public String test(){
        return name+""+app;
    }






}

