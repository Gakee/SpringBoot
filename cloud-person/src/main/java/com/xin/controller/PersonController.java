package com.xin.controller;

import com.xin.dao.PersonRepository;
import com.xin.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public List<Person> savePerson(@RequestBody String personName){
        Person person = new Person(personName);
        personRepository.save(person);
        List<Person> people = personRepository.findAll(new PageRequest(0, 10))
                .getContent();
        return people;
    }

    /**
     * feignClient测试学习
     */
    @RequestMapping(value = "/add/{a}/{b}",method = RequestMethod.GET)
    public void add(@PathVariable("a") int a,@PathVariable("b") int b){
        System.out.println(a + b);
    }
}
