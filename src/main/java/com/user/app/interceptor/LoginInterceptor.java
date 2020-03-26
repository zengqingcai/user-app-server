package com.user.app.interceptor;

import com.user.app.config.RedisUtil;
import com.user.app.model.TestUser;
import com.user.app.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor implements HandlerInterceptor{

    public boolean preHandleCopy(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
        if (null == user || !(user instanceof TestUser)) {
            response.sendRedirect("/login");
            return false;
        }else{
            UserContext.setTestUser((TestUser)user);
            return true;
        }
    }

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        Cookie cookie = getCookie(request, "zengyiliang");
//        if (null == cookie) {
//            response.sendRedirect("/login");
//            return false;
//        } else {
//            TestUser user = (TestUser) redisUtil.get(cookie.getValue());
//            UserContext.setTestUser(user);
//            return true;
//        }
        return true;

    }

    private Cookie getCookie(HttpServletRequest request,String targetKey){
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length>0) {
            for (Cookie cookie : cookies) {
                if (targetKey.equals(cookie.getName())) {
                    return cookie;
                }
            }
        }
        return null;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
