package com.yyesw.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/13
 * <br/>Time: 14:50
 */

@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        // https://news.baidu.com/guonei
        routes.route("path_route_yyesw",  //配置每名称为path_route_yyesw 的路由规则
                                    r -> r.path("/guonei")  //将项目xx/guonei请求转发到下面链接
                                            .uri("https://news.baidu.com/guonei")).build();
        return routes.build();
    }

    @Bean
    public RouteLocator customRouteLocatorTest(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_yyesw2",  //配置每名称为path_route_yyesw 的路由规则
                r -> r.path("/guoji")  //将项目xx/guonei请求转发到下面链接
                        .uri("https://news.baidu.com/guonji")).build();

        return routes.build();
    }
}
