package com.xin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElasticApplication {
    public static void main(String[] args) {
        System.out.println("hello, Elastic!!");
        SpringApplication.run(ElasticApplication.class,args);
    }
}
