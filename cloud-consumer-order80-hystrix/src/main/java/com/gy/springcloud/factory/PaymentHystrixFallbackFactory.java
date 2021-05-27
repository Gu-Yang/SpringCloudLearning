package com.gy.springcloud.factory;

import com.gy.springcloud.service.PaymentHystrixService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixFallbackFactory implements FallbackFactory<PaymentHystrixService> {
    @Override
    public PaymentHystrixService create(Throwable throwable) {
        return new PaymentHystrixService() {
            @Override
            public String PaymentInfo_Ok(Integer id) {
                return "Fallback ==== Factory way ==== ok";
            }

            @Override
            public String PaymentInfo_Timeout(Integer id) {
                return "Fallback ==== Factory way ==== timeout";
            }
        };
    }
}
