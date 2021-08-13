package com.yyesw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/13
 * <br/>Time: 10:34
 */

@EnableEurekaClient
@SpringBootApplication
public class GateWayMain9527 {

    public static void main(String[] args) {
        SpringApplication.run(GateWayMain9527.class,args);
    }
}
