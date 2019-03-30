package com.omen.controller;

import entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Auther: xuzhoukai
 * @Date: 2019/3/22 18:42
 * @Description:
 */
@RestController
public class PersonProxyController {

    @Autowired
    private RestTemplate restTemplate;

    private final String URI = "http://PERSON-SERVICE";

    @RequestMapping("/save")
    public boolean save(Person person){
        Boolean result = restTemplate.getForEntity(URI+"/save?name="+person.getName()+"&id="+person.getId(),Boolean.class,person).getBody();
        return result;
    }

    @RequestMapping("/find/all")
    public List<Person> findAll(){
        List<Person> list = restTemplate.getForEntity(URI+"/find/all",List.class).getBody();
        return list;
    }
}
