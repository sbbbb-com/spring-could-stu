package com.yyesw.springcloud.service;

import com.yyesw.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/18
 * <br/>Time: 15:16
 *
 *<p>库存的服务</p>
 */

@FeignClient(value = "seata-storage-service" /*告诉未来的调用的库存微服务的名称*/)
public interface StorageService {

    /**
     * 对某个商品的数量上的减少操作
     * @param productId 商品编号
     * @param count  操作数量
     * @return
     */
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId")Long productId,
                          @RequestParam("count")Integer count);
}
