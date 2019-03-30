package com.omen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

/**
 * @Auther: xuzhoukai
 * @Date: 2019/3/30 17:45
 * @Description:
 */
@SpringBootApplication
//@EnableZipkinServer
@EnableZipkinStreamServer
public class ZipkinServerSpringAppliction {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerSpringAppliction.class,args);
    }
}
