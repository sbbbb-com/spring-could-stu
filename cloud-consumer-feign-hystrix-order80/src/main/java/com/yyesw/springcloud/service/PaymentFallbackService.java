package com.yyesw.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/12
 * <br/>Time: 20:59
 * 降价方法的返回值类型必须与需要降价的方法一致
 */

@Component
public class PaymentFallbackService implements PaymentHystrixService{


    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK , (┬＿┬)";

    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut , (┬＿┬)";
    }
}
