package com.asyncscheduling.asyncscheduling;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyScheduler {

    //    @Scheduled(fixedRate = 200) // NOT concurrent
    @Async()
    void logMe() {
        log.info("Scheduler1 started... {}", Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

//    @Scheduled(fixedRate = 200) // NOT concurrent
//    void logYou() {
//        log.info("Scheduler2 started... {}", Thread.currentThread().getName());
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

}
