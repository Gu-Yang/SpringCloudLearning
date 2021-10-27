package com.gy.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AliPayment9001 {
    public static void main(String[] args) {
        SpringApplication.run(AliPayment9001.class, args);
    }
}
