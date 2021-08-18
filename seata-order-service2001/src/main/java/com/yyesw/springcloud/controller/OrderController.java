package com.yyesw.springcloud.controller;

import com.yyesw.springcloud.domain.CommonResult;
import com.yyesw.springcloud.domain.Order;
import com.yyesw.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/18
 * <br/>Time: 16:05
 */

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){

        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
