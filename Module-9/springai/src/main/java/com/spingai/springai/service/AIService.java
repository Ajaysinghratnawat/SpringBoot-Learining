package com.spingai.springai.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AIService {
    private final ChatClient chatClient;
    private final EmbeddingModel embeddingModel;
    private final VectorStore vectorStore;

    public float[] getEmbedding(String text){
        return embeddingModel.embed(text);
    }

    public void ingestDataToVectorStore(String text){
        List<Document> documents = List.of(
                new Document("""
                    Spring Boot is a Java framework for building production-ready applications.
                    It simplifies dependency management, auto-configuration, and embedded servers.
                    """),
                new Document("""
                    Spring AI provides abstractions for integrating Large Language Models (LLMs)
                    like OpenAI, Ollama, Azure OpenAI, and Anthropic into Spring applications.
                    """),
                new Document("""
                    Ollama allows developers to run open-source LLMs locally.
                    Popular models include llama3, qwen3, mistral, and gemma.
                    """),
                new Document("""
                    PostgreSQL is an open-source relational database.
                    The pgvector extension enables vector similarity search for AI applications.
                    """),
                new Document("""
                    Retrieval-Augmented Generation (RAG) combines vector search with LLMs
                    to answer questions using external knowledge.
                    """)
        );
        vectorStore.add(documents);
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
