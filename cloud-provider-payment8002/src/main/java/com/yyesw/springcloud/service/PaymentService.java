package com.yyesw.springcloud.service;

import com.yyesw.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/9
 * <br/>Time: 16:41
 */

public interface PaymentService {

    public int create(Payment payment);

    public  Payment getPaymentById(@Param("id")Long id);
}
