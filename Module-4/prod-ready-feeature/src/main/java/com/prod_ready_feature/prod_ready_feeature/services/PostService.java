package com.prod_ready_feature.prod_ready_feeature.services;

import com.prod_ready_feature.prod_ready_feeature.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> getAllPosts();

    PostDto createNewPost(PostDto inputPost);
}
