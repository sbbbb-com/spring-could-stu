package com.yyesw.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/11
 * <br/>Time: 20:03
 */

@Slf4j
@Component
public class MyLB implements LoadBalancer {

    /**
     * 原子类
     */
    private  AtomicInteger atomicInteger=new AtomicInteger(0);

    public final int getAndIncrement(){

        int current;
        int next;

        do {
            current=this.atomicInteger.get();
            next=current>=Integer.MAX_VALUE?0:current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        log.info("******第几次访问next,次数:【{}】******",next);
        return next;
    }

    /**
     * 负载均衡算法: rest接口第几次请求数%服务器集群总数量–实际调用服务器位置下标，每次服务重启动后rest接口计数从1开始。
     * @param serviceInstances
     * @return
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
