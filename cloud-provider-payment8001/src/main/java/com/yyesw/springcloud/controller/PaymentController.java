package com.yyesw.springcloud.controller;

import com.yyesw.springcloud.entities.CommonResult;
import com.yyesw.springcloud.entities.Payment;
import com.yyesw.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/9
 * <br/>Time: 16:48
 */

@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;


    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){

        int result = paymentService.create(payment);
        log.info("成功插入数据{}条",result);

        if (result>0){
            return new CommonResult(200,"插入数据库成功",result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){

        Payment result = paymentService.getPaymentById(id);
        log.info("返回查询返回数据消息为：：【{}】!！",result);

        int age=10/2;

        if (result!=null){
            return new CommonResult(200,"查询成功",result);
        }else {
            return new CommonResult(444,"没有对应id为【"+id+"】的记录！！",null);
        }
    }
}
