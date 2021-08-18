package com.yyesw.springcloud.dao;

import com.yyesw.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/18
 * <br/>Time: 11:31
 */

@Mapper
public interface OrderDao {

    //1.新建订单
    void create(Order order);

    //2.修改订单状态，从零改到1
    void update(@Param("userId")Long userId,@Param("status")Integer status);
}
