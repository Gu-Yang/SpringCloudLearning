package com.gy.springcloud.controller;

import com.gy.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "breakerFallbackMethod")
public class OrderHystrixController {

    @Qualifier("com.gy.springcloud.service.PaymentHystrixService")
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String PaymentInfo_Ok(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.PaymentInfo_Ok(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String PaymentInfo_Timeout(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.PaymentInfo_Timeout(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/breaker/{id}")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),   //是否打开断路器，默认为true
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //时间窗口内触发熔断的最小请求次数，默认为20
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //判断是否需要熔断的时间窗口，默认为5000ms
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //失败率达到多少百分比后熔断，默认为50
    })
    public String PaymentInfo_breaker(@PathVariable("id") Integer id) {
//        String result = paymentHystrixService.PaymentInfo_Timeout(id);
        if ( id < 0) {
            throw new RuntimeException("id不能为负数");
        }

        return "调用成功，流水号： " + UUID.randomUUID().toString();
    }

    public String breakerFallbackMethod() {
        return "出现异常或超时，请稍后再试";
    }

}
