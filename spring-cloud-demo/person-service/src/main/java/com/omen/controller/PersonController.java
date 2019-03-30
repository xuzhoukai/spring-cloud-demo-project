package com.omen.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import entity.Person;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Auther: xuzhoukai
 * @Date: 2019/3/22 18:24
 * @Description:
 */
@RestController
public class PersonController {

    private List<Person> list = new ArrayList<Person>();

    @RequestMapping("/save")
    public boolean save(Person person){
        list.add(person);
        return true;
    }

    @RequestMapping("/find/all")
    @HystrixCommand(fallbackMethod = "findAllFailback" ,commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                    value = "100")
    })
    public List<Person> findAll() throws InterruptedException {
        Random random = new Random();
        int time = random.nextInt(200);
        System.out.println("系统执行时间(毫秒):"+time);
        Thread.sleep(time);
        return list;
    }

    public List<Person> findAllFailback(){
        System.out.println("熔断保护");
        return new ArrayList<Person>();
    }
}
