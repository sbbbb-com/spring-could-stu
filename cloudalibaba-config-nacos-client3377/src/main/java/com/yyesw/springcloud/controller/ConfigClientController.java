package com.yyesw.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/15
 * <br/>Time: 14:34
 */

@Slf4j
@RefreshScope  /*支持动态刷新 实现配置的自动更新*/
@RestController
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        log.info("进入：：ConfigClientController！！");
        return configInfo;
    }


}
