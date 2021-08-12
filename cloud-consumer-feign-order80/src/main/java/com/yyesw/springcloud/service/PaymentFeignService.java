package com.yyesw.springcloud.service;

import com.yyesw.springcloud.entities.CommonResult;
import com.yyesw.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/11
 * <br/>Time: 21:04
 */

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {


     // public CommonResult<Payment> getPaymentById(@Param("id")Long id);

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id);


    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();
}
