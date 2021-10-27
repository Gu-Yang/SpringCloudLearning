package alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AliPayment9002 {
    public static void main(String[] args) {
        SpringApplication.run(AliPayment9002.class, args);
    }
}
