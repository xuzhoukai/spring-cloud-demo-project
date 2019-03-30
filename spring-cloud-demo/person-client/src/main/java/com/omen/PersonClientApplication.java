package com.omen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: xuzhoukai
 * @Date: 2019/3/22 18:49
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PersonClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(PersonClientApplication.class,args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
