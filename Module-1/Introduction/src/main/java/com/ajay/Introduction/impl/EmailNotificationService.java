package com.ajay.Introduction.impl;

import com.ajay.Introduction.NotificationService;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Sending email "+message);
    }
}
