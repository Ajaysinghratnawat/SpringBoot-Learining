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
    public void testAskAI(){
        var res = aiService.askAI("What is spring AI?"); //explain bcz present in db
//        var res = aiService.askAI("What is apple?");  //I dont know bcz no detail in db
        System.out.println(res);
    }
    @Test
    public void testaskAIWithAdvisors(){
//        String res = aiService.askAIWithAdvisors("can you tell me the capital of india and also my name is ajay","ajay123");
        String res = aiService.askAIWithAdvisors("What is my name ?","ajay123");
        System.out.println(res);
    }
    @Test
    public void testGetJoke(){
        var joke = aiService.get_joke("cat");
        System.out.println(joke);
    }

    @Test
    public void testEmbededText(){
        var embed = aiService.getEmbedding("This is a big text here");
        System.out.println(embed.length);
        for (float e: embed){
            System.out.println(e);
        }
    }

    @Test
    public void testStoreData(){
        aiService.ingestDataToVectorStore();
    }

    @Test
    public void testSimilaritySearch(){
        var res = aiService.similaritySearch("open");
        for (var docs:res){
            System.out.println(res);
        }
    }

    @Test
    public void testIngest(){
        aiService.ingestpdfToVectoreStore();
    }

}