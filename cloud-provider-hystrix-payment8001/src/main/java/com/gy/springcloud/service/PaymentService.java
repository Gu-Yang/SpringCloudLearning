package com.gy.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentInfo_Ok(Integer id) {
        return "Thread pool: " +Thread.currentThread().getName() + " paymentInfo_OK, id: " + id;
    }

//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//    })
    public String paymentInfo_Timeout(Integer id) {
        try {
            TimeUnit.MILLISECONDS.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Thread pool: " +Thread.currentThread().getName() + " paymentInfo_Timeout, id: " + id;
    }

//    public String paymentInfo_TimeoutHandler(Integer id) {
//        return "Thread pool: " +Thread.currentThread().getName() + " paymentInfo_TimeoutHandler, id: " + id + "服务访问超时，请稍后再试。";
//    }

}
