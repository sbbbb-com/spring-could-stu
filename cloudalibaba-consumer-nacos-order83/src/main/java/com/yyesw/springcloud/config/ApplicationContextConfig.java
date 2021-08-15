package com.yyesw.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/15
 * <br/>Time: 11:44
 */

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced  /*负载均衡时候 记得加上这个注解*/
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }

}
