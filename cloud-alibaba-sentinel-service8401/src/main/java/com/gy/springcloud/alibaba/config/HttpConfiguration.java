package com.gy.springcloud.alibaba.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpConfiguration {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
