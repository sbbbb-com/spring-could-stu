package com.yyesw.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/11
 * <br/>Time: 14:38
 */

@Slf4j
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/consul")
    public String paymentConsul(){
        return "springcloud with CONSUL:"+serverPort+"\t"+ UUID.randomUUID().toString();
    }

}
