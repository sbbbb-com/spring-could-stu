package com.yyesw.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/9
 * <br/>Time: 15:57
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable/*实现序列化*/ {

    private Long id;
    private String serial;
}
