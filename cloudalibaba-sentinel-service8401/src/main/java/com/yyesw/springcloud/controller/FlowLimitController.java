package com.yyesw.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/16
 * <br/>Time: 14:21
 */

@Slf4j
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        log.info(".FlowLimitController testA");
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {

        log.info(".FlowLimitController testB,地址{}",Thread.currentThread().getName());
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD()
    {
        //暂停一秒线程
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("testD 测试RT");

        return "------testD";
    }

}
