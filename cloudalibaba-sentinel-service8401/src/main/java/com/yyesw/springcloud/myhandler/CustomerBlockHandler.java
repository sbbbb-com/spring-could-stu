package com.yyesw.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yyesw.springcloud.entities.CommonResult;
import com.yyesw.springcloud.entities.Payment;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/17
 * <br/>Time: 13:36
 */

public class CustomerBlockHandler {

    public static CommonResult handleExeption1(BlockException exception){

       return new CommonResult(44,"按照客户自定义，global handleExeption1");
    }

    public static CommonResult handleExeption2(BlockException exception){

        return new CommonResult(44,"按照客户自定义，global handleExeption2");
    }
}
