package com.yyesw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/11
 * <br/>Time: 14:34
 */

@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain8006 {

    public static void main(String[] args) {

        SpringApplication.run(PaymentMain8006.class,args);
    }

}
