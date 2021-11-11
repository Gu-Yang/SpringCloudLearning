package com.gy.springcloud.alibaba.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService{
//    @Override
//    public String byResource() {
//        return "Service called failed2! ---- processed by PaymentFallbackService";
//    }
    @Override
    public String getPayment(Integer id) {
        return "Service called failed! ---- processed by PaymentFallbackService";
    }
}
