package com.aop.aop.services.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShipmentServiceImplTest {
    @Autowired
    private ShipmentServiceImpl shipmentService;

    @Test
    void orderPackage() {
        shipmentService.orderPackage(4L);
    }

    @Test
    void trackPackage() {
        shipmentService.trackPackage(4L);
    }
}