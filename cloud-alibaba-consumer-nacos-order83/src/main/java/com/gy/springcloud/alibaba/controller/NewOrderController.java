package com.gy.springcloud.alibaba.controller;

import com.gy.springcloud.alibaba.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewOrderController {

    @Qualifier("com.gy.springcloud.alibaba.service.PaymentService")
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/{id}")
    public String PaymentInfo(@PathVariable("id") Integer id) {
        return paymentService.getPayment(id);
    }

//    @GetMapping("/consumer/sentinel")
//    public String PaymentInfo() {
//        return paymentService.byResource();
//    }
}
