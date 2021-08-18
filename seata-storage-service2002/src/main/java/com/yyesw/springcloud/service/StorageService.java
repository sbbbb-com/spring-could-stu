package com.yyesw.springcloud.service;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/18
 * <br/>Time: 16:45
 */

public interface StorageService {

    // 扣减库存
    void decrease(Long productId, Integer count);

}
