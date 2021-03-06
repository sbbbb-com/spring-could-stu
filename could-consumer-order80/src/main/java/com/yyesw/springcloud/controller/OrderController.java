package com.yyesw.springcloud.controller;

import com.sun.corba.se.spi.ior.IdentifiableFactory;
import com.yyesw.springcloud.entities.CommonResult;
import com.yyesw.springcloud.entities.Payment;
import com.yyesw.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/9
 * <br/>Time: 18:10
 */

@Slf4j
@RestController
public class OrderController {

    //public static final String PAYMENT_URL="http://localhost:8001";
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

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
        /**
         * 返回对象为响应体中数据转化成的对象，基本上可以理解为Json
         */
        return restTemplate.getForObject(url,CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id")Long id){

        String url=PAYMENT_URL+"/payment/get/"+id;
        /**
         * 返回对象为ResponseEntity对象，包含了响应中的一些重要信息，比如响应头、响应状态码、响应体等
         */
        ResponseEntity<CommonResult> entity=restTemplate.getForEntity(url,CommonResult.class);

        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult(444,"操作失败");
        }
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){

        log.info("执行到自定义getPaymentLB  ！！！！");

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances==null || instances.size()<=0){
            return  null;
        }
        ServiceInstance serviceInstance=loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to yyesw，O(∩_∩)O哈哈~";
    }
}
