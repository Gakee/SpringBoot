package com.xin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient//eureka客户端
@EnableFeignClients//feign客户端支持
@EnableCircuitBreaker//circuitBreaker支持
@EnableZuulProxy//网关代理支持
public class UiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UiApplication.class,args);
    }
}
