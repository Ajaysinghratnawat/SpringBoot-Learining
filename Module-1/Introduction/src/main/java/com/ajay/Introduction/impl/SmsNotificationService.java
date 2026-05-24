package com.ajay.Introduction.impl;

import com.ajay.Introduction.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Qualifier("sms")
//@Primary
@Component
@ConditionalOnProperty(name="notification.type",havingValue = "sms")//check in application.properties then injet
public class SmsNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Sending sms "+message);
    }
}
