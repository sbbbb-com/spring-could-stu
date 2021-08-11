package com.yyesw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/9
 * <br/>Time: 15:20
 *
 * 主启动类
 */

@EnableEurekaClient   /*添加client端的注解*/
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8001 {

    public static void main(String[] args) {

        SpringApplication.run(PaymentMain8001.class,args);
    }
}
