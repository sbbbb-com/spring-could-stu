package com.yyesw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/9
 * <br/>Time: 18:04
 */

@EnableEurekaClient
@SpringBootApplication
public class OrderMain80 {

    public static void main(String[] args) {

        SpringApplication.run(OrderMain80.class,args);
    }
}
