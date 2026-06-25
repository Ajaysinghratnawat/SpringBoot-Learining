package com.spingai.springai.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AIServiceTest {
    @Autowired
    private AIService aiService;
    @Test
    public void tesGetJoke(){
        var joke = aiService.get_joke("Dogs");
        System.out.println(joke);
    }

}