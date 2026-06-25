package com.spingai.springai.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AIService {
    private final ChatClient chatClient;

    public String get_joke(String topic){

        String systempPrompt = """
                Give a joke on topic {topic}
                """;
        PromptTemplate promptTemplate = new PromptTemplate(systempPrompt);
        String renderedText = promptTemplate.render(Map.of("topic",topic));
        return chatClient.prompt()
                .user(renderedText)
                .call()
                .content();

//        return chatClient.prompt()
//                .user("Give me a joke on the topic: "+topic)
//                .call()
//                .content();
    }
}
