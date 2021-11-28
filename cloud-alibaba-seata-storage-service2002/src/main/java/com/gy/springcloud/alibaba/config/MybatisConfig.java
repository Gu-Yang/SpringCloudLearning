package com.gy.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = "com.gy.springcloud.alibaba.dao")
public class MybatisConfig {
}
