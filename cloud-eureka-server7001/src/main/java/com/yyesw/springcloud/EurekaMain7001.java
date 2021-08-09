package com.yyesw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/9
 * <br/>Time: 22:00
 */

@SpringBootApplication
@EnableEurekaServer   //代表本EurekaMain7001就是  注册中心 由此管理注册 登记
public class EurekaMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
    }
}
