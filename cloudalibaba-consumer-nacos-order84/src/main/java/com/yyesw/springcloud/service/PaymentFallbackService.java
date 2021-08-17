package com.yyesw.springcloud.service;

import com.yyesw.springcloud.entities.CommonResult;
import com.yyesw.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/17
 * <br/>Time: 21:00
 */

@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<Payment>(
                4444,"服务降级返回，---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
