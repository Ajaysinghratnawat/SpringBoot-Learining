package com.prod_ready_feature.prod_ready_feeature.controllers;

import com.prod_ready_feature.prod_ready_feeature.dto.PostDto;
import com.prod_ready_feature.prod_ready_feeature.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }

    @PostMapping
    public PostDto createNewPost(@RequestBody PostDto postDto){
        return postService.createNewPost(postDto);
    }
}
