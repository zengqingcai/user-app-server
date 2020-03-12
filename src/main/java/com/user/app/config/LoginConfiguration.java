package com.user.app.config;

import com.user.app.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class LoginConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        //LoginInterceptor loginInterceptor = new LoginInterceptor();
        //https://blog.csdn.net/Zhao_yanpeng/article/details/102739898
        //原因是由于拦截器加载的时间点在springcontext之前，所以在拦截器中注入为null。
        InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor());
        // 拦截路径
        loginRegistry.addPathPatterns("/**");
        //排除路径
        loginRegistry.excludePathPatterns("/home");
        loginRegistry.excludePathPatterns("/register");
        loginRegistry.excludePathPatterns("/login");
        loginRegistry.excludePathPatterns("/doLogin");
        loginRegistry.excludePathPatterns("/logout");
//        loginRegistry.excludePathPatterns("/emp/empRegister")
        loginRegistry.excludePathPatterns("/css/**");
        loginRegistry.excludePathPatterns("/js/**");
        loginRegistry.excludePathPatterns("/images/**");
        //验证码
        loginRegistry.excludePathPatterns("/getValidCode");
    }

    //先实例化它
    //知道拦截器执行在bean实例化前执行的，那么我们就让拦截器执行之前实例化拦截器Bean。
    @Bean
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }


}
