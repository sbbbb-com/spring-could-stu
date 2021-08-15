package com.yyesw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/15
 * <br/>Time: 14:32
 */

@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigClientMain3377 {

    public static void main(String[] args) {

        SpringApplication.run(NacosConfigClientMain3377.class,args);
    }
}
