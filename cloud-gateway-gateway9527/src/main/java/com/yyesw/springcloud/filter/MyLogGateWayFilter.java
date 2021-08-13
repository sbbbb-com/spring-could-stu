package com.yyesw.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/13
 * <br/>Time: 21:07
 */

@Slf4j
@Configuration
public class MyLogGateWayFilter implements GlobalFilter, Ordered {


    /**
     * 处理 Web 请求并（可选）通过给定的
     * {@link GatewayFilterChain} 委托给下一个 {@code WebFilter}。
     *
     * @param exchange 当前服务器交换机
     * @param chain    提供一种委托给下一个过滤器的方法
     * @return {@code Mono<Void>} 指示请求处理何时完成
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("*********************come in MyLogGateWayFilter:{}",new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (uname==null){
            log.info("*********用户名为空 非法用户！！::>_<::！！");
            //设置返回状态码
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        //合法用户放行
        return chain.filter(exchange);
    }

    /**
     * 获取此对象的优先级值    【返回数值越小 优先级越高】
     * <p>较高的值被解释为较低的优先级。因此，具有最低值的对象具有最高优先级（
     * 有点类似于 Servlet {@code load-on-startup} 值）。 <p>
     * 相同的顺序值将导致受影响对象的任意排序位置。
     *
     * @return the order value
     * @see #HIGHEST_PRECEDENCE
     * @see #LOWEST_PRECEDENCE
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
