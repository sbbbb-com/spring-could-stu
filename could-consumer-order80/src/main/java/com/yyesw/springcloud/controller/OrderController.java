package com.yyesw.springcloud.controller;

import com.yyesw.springcloud.entities.CommonResult;
import com.yyesw.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/9
 * <br/>Time: 18:10
 */

@Slf4j
@RestController
public class OrderController {

    public static final String PAYMENT_URL="http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){

        log.info("OrderController接收到的参数 payment：{}",payment);

        String url=PAYMENT_URL+"/payment/create";
        return restTemplate.postForObject(url,payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")Long id){
        log.info("OrderController接收到的参数 id：{}",id);

        String url=PAYMENT_URL+"/payment/get/"+id;
        return restTemplate.getForObject(url,CommonResult.class);
    }
}
