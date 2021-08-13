package com.yyesw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/13
 * <br/>Time: 22:43
 */

@EnableConfigServer
@SpringBootApplication
public class ConfigCenterMain3344 {

    public static void main(String[] args) {

        SpringApplication.run(ConfigCenterMain3344.class,args);
    }
}
