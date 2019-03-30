package com.omen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther: xuzhoukai
 * @Date: 2019/3/22 18:33
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class PersonServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PersonServiceApplication.class,args);
    }
}
