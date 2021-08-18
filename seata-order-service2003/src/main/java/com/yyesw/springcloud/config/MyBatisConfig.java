package com.yyesw.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/18
 * <br/>Time: 16:10
 */

@Configuration
@MapperScan({"com.yyesw.springcloud.dao"})
public class MyBatisConfig {
}
