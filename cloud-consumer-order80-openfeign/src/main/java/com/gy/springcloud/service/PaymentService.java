package com.gy.springcloud.service;

import com.gy.springcloud.entities.CommonResult;
import com.gy.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient("CLOUD-PAYMENT-SERVICE")
@FeignClient("cloud-payment-service")
public interface PaymentService {
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> ge(@PathVariable("id") Long id);

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment);

    @GetMapping("/payment/timeout")
    public String timeout();
}
