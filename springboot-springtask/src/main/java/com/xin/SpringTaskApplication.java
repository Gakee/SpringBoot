package com.xin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // 开启定时任务支持,也可以写在配置类上
public class SpringTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringTaskApplication.class,args);
    }
}
