package com.yyesw.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/9
 * <br/>Time: 16:01
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult <T>{

    private Integer code;
    private String message;
    private T       data;


    public CommonResult(Integer code, String message) {
        this(code,message,null);
    }
}
