package com.user.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

//@SpringBootApplication
//@ServletComponentScan(basePackages = {"com.user.app.filter"})
@SpringBootApplication(scanBasePackages = "com.user.app")
//@EnableCaching(proxyTargetClass = true) // 开启缓存功能
//@EnableAsync
//@MapperScan("com.user.base.**.dao")
@EnableFeignClients(basePackages = "com.user.app.remote")
@SpringCloudApplication
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