package com.xin.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Task {
    // 需要定时执行的任务
    @Scheduled(fixedRate = 1000) // 每秒执行一次
    public void task1(){
        System.out.println("task1在:"+ new Date() +"执行了");
    }

    @Scheduled(fixedDelay = 1000)
    public void task2(){
        System.out.println("task2在:"+ new Date() +"执行了");
    }

    @Scheduled(cron = "0/3 * * * * ?")
    public void task3(){
        System.out.println("task3在:"+ new Date() +"执行了");
    }
}
