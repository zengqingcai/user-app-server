package com.user.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class UserAppApplication extends SpringBootServletInitializer implements CommandLineRunner {
    // 入口
    public static void main(String[] args) {
        SpringApplication.run(UserAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("springboot启动完成！");
    }


}