package com.xin.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * es 配置类
 */
@Configuration
public class ElasticConfig {
    /**
     * rest high level client
     * @return
     */
    @Bean
    public RestHighLevelClient createHighLevelClient(){
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")));
        return client;
    }

    /**
     * rest low level client
     */
    @Bean
    public RestClient creatClient(){
        return RestClient.builder(new HttpHost("localhost",9200,"http"))
                .build();
    }

}
