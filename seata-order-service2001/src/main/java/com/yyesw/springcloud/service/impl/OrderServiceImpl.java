package com.yyesw.springcloud.service.impl;

import com.yyesw.springcloud.dao.OrderDao;
import com.yyesw.springcloud.domain.Order;
import com.yyesw.springcloud.service.AccountService;
import com.yyesw.springcloud.service.OrderService;
import com.yyesw.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/18
 * <br/>Time: 15:18
 */

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    //订单
    @Resource
    private OrderDao orderDao;

    //库存
    @Resource
    private StorageService storageService;

    //帐户
    @Resource
    private AccountService accountService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     */
    @GlobalTransactional(name = "fsp-create-order"/*保证名称唯一不冲突即可*/,
                         rollbackFor = Exception.class/*发生任何异常都回滚*/) /*全局事务*/
    @Override
    public void create(Order order) {

        //1.新建订单
        log.info("-------->1开始新建订单");
        orderDao.create(order);

        //2.调用库存服务 扣减库存
        log.info("--------->2.1订单微服务开始调用库存服务，做扣减操作开始");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("--------->2.2订单微服务开始调用库存，库存扣减结束！");

        //3.帐户余额操作  扣减账户
        log.info("--------->3.1订单微服务开始调用，做账号余额扣减操作开始");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("--------->3.2订单微服务开始调用帐户余额操作，做账号余额扣减操作结束！");

        //4.修改订单状态 从零到1 1代表完成
        log.info("--------->4.1修改订单状态开始");
        orderDao.update(order.getUserId(),1);
        log.info("--------->4.2修改订单状态操作结束");

        log.info("####此次下订单操作结束！！O(∩_∩)O~####");
        System.out.println("===========！！！分割线！！！===========\n" +
                "===========！！！分割线！！！===========\n" +
                "===========！！！分割线！！！===========\n");
    }




}
