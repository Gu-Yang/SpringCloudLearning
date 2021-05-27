package com.gy.springcloud.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class PaymentHystrixFallbackService implements PaymentHystrixService{
    @Override
    public String PaymentInfo_Ok(@PathVariable("id") Integer id) {
        return "-----Order fallback --------  ok --------";
    }
    @Override
    public String PaymentInfo_Timeout(@PathVariable("id") Integer id) {
        return "-----Order fallback --------  timeout --------";
    }
}
