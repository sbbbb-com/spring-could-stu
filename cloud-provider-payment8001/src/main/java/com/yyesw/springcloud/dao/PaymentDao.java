package com.yyesw.springcloud.dao;

import com.yyesw.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/9
 * <br/>Time: 16:07
 */

@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public  Payment getPaymentById(@Param("id")Long id);
}
