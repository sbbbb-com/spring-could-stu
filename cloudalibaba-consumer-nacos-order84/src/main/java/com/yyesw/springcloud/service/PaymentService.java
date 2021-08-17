package com.yyesw.springcloud.service;

import com.yyesw.springcloud.entities.CommonResult;
import com.yyesw.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/17
 * <br/>Time: 20:53
 */

@FeignClient(value = "nacos-payment-provider"/*正常调用这个服务*/,fallback = PaymentFallbackService.class/*错误兜底*/)
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id")Long id);
}
