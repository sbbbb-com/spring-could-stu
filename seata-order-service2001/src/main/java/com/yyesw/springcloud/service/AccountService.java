package com.yyesw.springcloud.service;

import com.yyesw.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/18
 * <br/>Time: 15:17
 */
@FeignClient(value = "seata-account-service" /*告诉未来的调用的账户操作微服务的名称*/)
public interface AccountService {

    /**
     * 根据用户编号id 修改用户余额
     * @param userId 用户id
     * @param money  用户余额
     * @return
     */
    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId")Long userId,
                          @RequestParam("money")BigDecimal money);
}
