package com.spingai.springai.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AIService {
    private final ChatClient chatClient;
    private final EmbeddingModel embeddingModel;
    private final VectorStore vectorStore;

    public float[] getEmbedding(String text){
        return embeddingModel.embed(text);
    }

    public String askAI(String prompt){
        String template = """
            You are an AI assistant that answers ONLY using the CONTEXT below.

            Rules:
            - Answer strictly and only from the CONTEXT section.
            - Do NOT use any prior/outside knowledge, even if you are confident about the answer.
            - Do NOT infer, guess, or fill gaps with general knowledge.
            - If the CONTEXT does not contain the answer, respond with exactly: "I dont know"
            - Do not explain why you don't know. Just respond with "I dont know".

            CONTEXT:
            {context}
            """;

        List<Document> documents = vectorStore.similaritySearch(SearchRequest.builder()
                .query(prompt)
                .topK(2)
                .similarityThreshold(0.5) // filter out irrelevant matches
                .filterExpression("topic =='ai' or topic == 'vectorstore'")
                .build());

        if (documents.isEmpty()) {
            return "I dont know";
        }

        String context = documents.stream()
                .map(Document::getText)
                .collect(Collectors.joining("\n\n"));

        PromptTemplate promptTemplate = new PromptTemplate(template);
        String systemPrompt = promptTemplate.render(Map.of("context", context));

        return chatClient.prompt()
                .system(systemPrompt)
                .user(prompt)
                .advisors(new SimpleLoggerAdvisor())
                .call()
                .content();
    }
    public void ingestDataToVectorStore() {
        List<Document> documents = List.of(
                new Document("Spring AI provides abstractions for LLMs...", Map.of("topic", "ai")),
                new Document("PostgreSQL pgvector enables vector search...", Map.of("topic", "ai"))
        );
        vectorStore.add(documents);
        vectorStore.add(springAiDocs());
    }

    public static List<Document> springAiDocs(){
        return List.of(
                new Document("Spring Boot...", Map.of("topic", "ai")),
                new Document("Spring AI...", Map.of("topic", "ai")),
                new Document("Ollama...", Map.of("topic", "ai")),
                new Document("PostgreSQL...", Map.of("topic", "ai")),
                new Document("RAG...", Map.of("topic", "ai"))
        );
    }

    public List<Document> similaritySearch(String text){
//        return vectorStore.similaritySearch(text);
        return vectorStore.similaritySearch(SearchRequest.builder()
                        .query(text)
                        .topK(3)
                        .similarityThreshold(0.3)
                .build());
    }

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
