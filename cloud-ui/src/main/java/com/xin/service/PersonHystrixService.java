package com.xin.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xin.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonHystrixService {

    @Autowired
    PersonService personService;//feign中有默认熔断机制方法

    @HystrixCommand(fallbackMethod = "fallbackSave") //声明熔断机制调用方法
                                    //fallbackSave
    public List<Person> save(String name){
        return personService.save(name);
    }

    //熔断机制调用方法
    public List<Person> fallbackSave(){
        List<Person> list = new ArrayList<>();
        Person p = new Person("person Service 服务故障");
        list.add(p);
        return list;
    }

    public List<Person> fallbackSave(String name){
        List<Person> list = new ArrayList<>();
        Person p = new Person(name+"没有保存成功，Person Service 故障");
        list.add(p);
        return list;
    }
}
