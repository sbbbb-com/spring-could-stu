package com.yyesw.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/9
 * <br/>Time: 19:22
 */

@Configuration
public class ApplicationContextConfig {


    @LoadBalanced  //使用@LoadBalanced赋予了RestTemplate负载均衡的能力
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
