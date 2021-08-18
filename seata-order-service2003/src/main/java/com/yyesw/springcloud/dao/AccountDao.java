package com.yyesw.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/18
 * <br/>Time: 17:26
 */

@Mapper
public interface AccountDao {

    /**
     * 扣减账户余额
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);

}
