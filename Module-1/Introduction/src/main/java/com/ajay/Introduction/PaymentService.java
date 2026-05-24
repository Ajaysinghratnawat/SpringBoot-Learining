package com.ajay.Introduction;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.time.Clock;
//Bean
@Component
public class PaymentService {
    public void pay(){
        System.out.println("paying");
    }
    @PostConstruct
    public void afterInit(){
        System.out.println("Init");
    }
    @PreDestroy
    public void beforeDestroy(){
        System.out.println("Destroy");
    }
}
