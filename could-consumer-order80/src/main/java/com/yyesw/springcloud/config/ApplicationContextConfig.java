package com.yyesw.springcloud.config;

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


    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
