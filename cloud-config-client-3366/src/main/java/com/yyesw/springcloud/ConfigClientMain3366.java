package com.yyesw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/14
 * <br/>Time: 14:57
 */

@EnableEurekaClient
@SpringBootApplication
public class ConfigClientMain3366 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3366.class,args);
    }
}
