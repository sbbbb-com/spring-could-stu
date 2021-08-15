package com.yyesw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/15
 * <br/>Time: 11:06
 */
@EnableDiscoveryClient  /*使用此即可*/
@SpringBootApplication
public class PaymentMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9001.class,args);
    }
}
