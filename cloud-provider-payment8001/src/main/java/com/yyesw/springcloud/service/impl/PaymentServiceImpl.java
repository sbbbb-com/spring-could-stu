package com.yyesw.springcloud.service.impl;

import com.yyesw.springcloud.dao.PaymentDao;
import com.yyesw.springcloud.entities.Payment;
import com.yyesw.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/9
 * <br/>Time: 16:44
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
