package com.xin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("test")
@RestController
@RequestMapping("/test")
public class ElasticController {

    @Autowired
    private RestHighLevelClient Client;

    @PostMapping("/insert/list")
    @ApiOperation(value = "test insert",notes = "test insert")
    public void listInsert(){
//        { "price" : 10000, "color" : "red", "make" : "honda", "sold" : "2014-10-28" }
//        { "index": {}}
//        { "price" : 20000, "color" : "red", "make" : "honda", "sold" : "2014-11-05" }
//        { "index": {}}
//        { "price" : 30000, "color" : "green", "make" : "ford", "sold" : "2014-05-18" }
//        { "index": {}}
//        { "price" : 15000, "color" : "blue", "make" : "toyota", "sold" : "2014-07-02" }
//        { "index": {}}
//        { "price" : 12000, "color" : "green", "make" : "toyota", "sold" : "2014-08-19" }
//        { "index": {}}
//        { "price" : 20000, "color" : "red", "make" : "honda", "sold" : "2014-11-05" }
//        { "index": {}}
//        { "price" : 80000, "color" : "red", "make" : "bmw", "sold" : "2014-01-01" }
//        { "index": {}}
//        { "price" : 25000, "color" : "blue", "make" : "ford", "sold" : "2014-02-12" }


    }
}
