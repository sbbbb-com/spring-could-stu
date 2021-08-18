package com.yyesw.springcloud.domain;

import lombok.Data;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/18
 * <br/>Time: 16:36
 */

@Data
public class Storage {

    private Long id;

    // 产品id
    private Long productId;

    //总库存
    private Integer total;


    //已用库存
    private Integer used;


    //剩余库存
    private Integer residue;


}
