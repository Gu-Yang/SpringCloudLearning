package com.gy.springcloud.alibaba.controller;

import com.gy.springcloud.alibaba.domain.CommonResult;
import com.gy.springcloud.alibaba.domain.Order;
import com.gy.springcloud.alibaba.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "Order created successfully");
    }
}
