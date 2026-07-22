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
    public void testGetJoke(){
        var joke = aiService.get_joke("Dogs");
        System.out.println(joke);
    }

//    @Test
//    public void testEmbededText(){
//        var embed = aiService.getEmbedding("This is a big text here");
//        System.out.println(embed.length);
//        for (float e: embed){
//            System.out.println(e);
//        }
//    }

    @Test
    public void testStoreData(){
        aiService.ingestDataToVectorStore("This is a big text");
    }

    @Test
    public void testSimilaritySearch(){
        var res = aiService.similaritySearch("open");
        for (var docs:res){
            System.out.println(res);
        }
    }

}