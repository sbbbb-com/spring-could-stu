package com.yyesw.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yyesw.springcloud.entities.CommonResult;
import com.yyesw.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/17
 * <br/>Time: 13:14
 */

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleExeption")
    public CommonResult byResource(){

        return new CommonResult(200,"按资源名称限流测试ok！",
                new Payment(2020l,"serial001"));
    }

    public CommonResult handleExeption(BlockException exception){

        return new CommonResult(444,exception.getClass().getCanonicalName()+"：：服务不可以");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){

        return new CommonResult(200,"按Url限流测试ok！",
                new Payment(2020l,"serial002"));
    }
}
