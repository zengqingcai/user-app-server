package com.user.app.service.user.impl;

import com.user.app.config.RedisUtil;
import com.user.app.interceptor.UserContext;
import com.user.app.model.TestUser;
import com.user.app.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisUtil redisUtil;

    public void doSavaUser(String cookieValue){
        TestUser user = (TestUser) redisUtil.get(cookieValue);
        UserContext.setTestUser(user);
    }
}
