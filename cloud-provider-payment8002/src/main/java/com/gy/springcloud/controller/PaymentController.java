package com.gy.springcloud.controller;

import com.gy.springcloud.entities.CommonResult;
import com.gy.springcloud.entities.Payment;
import com.gy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);

        log.info("=== Result：" + result + " ===");
        if (result > 0) {
            return new CommonResult(200, "Insert succeed! serverPort: " + serverPort, result);
        } else {
            return new CommonResult(430, "Insert Failed!", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);

        log.info("=== Result：" + payment + " ===");
        if (payment != null) {
            return new CommonResult(200, "Query succeed!, serverPort: " + serverPort, payment);
        } else {
            return new CommonResult(440, "No such record!", null);
        }
    }
}
