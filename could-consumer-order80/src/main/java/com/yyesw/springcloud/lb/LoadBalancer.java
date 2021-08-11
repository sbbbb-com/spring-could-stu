package com.yyesw.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/11
 * <br/>Time: 20:00
 */

public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
