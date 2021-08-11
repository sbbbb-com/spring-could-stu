package com.yyesw.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/11
 * <br/>Time: 17:19
 */

@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){

        // 定义 为随机
        return new RandomRule();
    }
}
