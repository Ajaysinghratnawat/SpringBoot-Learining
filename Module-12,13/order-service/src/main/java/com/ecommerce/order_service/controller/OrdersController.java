package com.ecommerce.order_service.controller;

import com.ecommerce.order_service.config.FeaturesEnableConfig;
import com.ecommerce.order_service.dto.OrderRequestDto;
import com.ecommerce.order_service.service.OrdersService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/core")
@RequiredArgsConstructor
@Slf4j
@RefreshScope
public class OrdersController {

    private final OrdersService ordersService;

    private final FeaturesEnableConfig featuresEnableConfig;

    @GetMapping("/helloOrders")
    public String helloOrders(@RequestHeader("X-User-Id") Long userId){
        if (featuresEnableConfig.isUserTrackingEnabled()){
            return "User tracking enabled, user id is : "+userId;
        }
        else {
            return "User tracking disabled, user id is : "+userId;
        }
    }

    @GetMapping
    public ResponseEntity<List<OrderRequestDto>> getAllOrders(HttpServletRequest httpServletRequest){
        log.info("Fetching all orders");
        List<OrderRequestDto> orders = ordersService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderRequestDto> getOrderById(@PathVariable Long id){
        log.info("Fetching order with id "+id);
        OrderRequestDto order = ordersService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

}
