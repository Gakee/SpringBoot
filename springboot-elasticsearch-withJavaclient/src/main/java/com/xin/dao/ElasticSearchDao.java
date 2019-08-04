package com.xin.dao;

import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ElasticSearchDao {

    @Autowired
    private RestClient restClient;

    @Autowired
    private RestHighLevelClient highLevelClient;

    /**
     * 增
     */
    public void listInsert(){

    }

    public void insert(){

    }
}
