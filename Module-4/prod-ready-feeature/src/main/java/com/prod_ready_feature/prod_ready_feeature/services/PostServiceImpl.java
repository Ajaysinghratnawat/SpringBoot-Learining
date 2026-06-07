package com.prod_ready_feature.prod_ready_feeature.services;

import com.prod_ready_feature.prod_ready_feeature.dto.PostDto;
import com.prod_ready_feature.prod_ready_feeature.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    @Override
    public PostDto createNewPost(PostDto inputPost) {
        return null;
    }

    @Override
    public List<PostDto> getAllPosts() {
        return null;
    }
}
