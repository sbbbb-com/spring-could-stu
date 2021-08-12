package com.yyesw.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/12
 * <br/>Time: 14:49
 */

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",
            fallback = PaymentFallbackService.class/*降价方法的返回值类型必须与需要降价的方法一致*/)
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);


    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id);
}
