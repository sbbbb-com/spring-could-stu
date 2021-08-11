package com.yyesw.springcloud.controller;

import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/11
 * <br/>Time: 11:42
 */

@Slf4j
@RestController
public class OrderZKController {

    public static final String INVOKE_URL="http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String paymentInfo(){

        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);

        return result;
    }
}
