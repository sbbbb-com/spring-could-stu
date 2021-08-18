package com.yyesw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/18
 * <br/>Time: 11:26
 */

@EnableDiscoveryClient
@EnableFeignClients
/*取消数据源自动创建的配置 使用我们自定义的*/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SeataOrderMainApp2001 {

    public static void main(String[] args) {

        SpringApplication.run(SeataOrderMainApp2001.class,args);
    }
}
