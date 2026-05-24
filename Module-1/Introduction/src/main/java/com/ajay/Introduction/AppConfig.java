package com.ajay.Introduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//@Bean,@Configuration
//Bean life cycle
@Configuration
public class AppConfig {
    @Bean
//    @Scope("prototype")
    PaymentService paymentService(){
        return new PaymentService();
    }

}
