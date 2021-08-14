package com.yyesw.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/14
 * <br/>Time: 9:32
 */

@RefreshScope  //刷新的注解标签
                /**
                 * 同时运维同学 发生post请求 刷新 3355
                 * 例如使用curl C:\Users\>curl -X POST "http://localhost:3355/actuator/refresh"
                 */
@RestController
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping(value = "/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }

}
