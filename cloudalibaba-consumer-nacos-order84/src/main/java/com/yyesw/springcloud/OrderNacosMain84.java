package com.yyesw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/17
 * <br/>Time: 14:14
 */

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class OrderNacosMain84 {

    public static void main(String[] args) {
        SpringApplication.run(OrderNacosMain84.class,args);
    }
}
