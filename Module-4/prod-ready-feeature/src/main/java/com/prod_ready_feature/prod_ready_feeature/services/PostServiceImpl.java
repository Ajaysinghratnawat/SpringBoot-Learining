package com.prod_ready_feature.prod_ready_feeature.services;

import com.prod_ready_feature.prod_ready_feeature.dto.PostDto;
import com.prod_ready_feature.prod_ready_feeature.entities.PostEntity;
import com.prod_ready_feature.prod_ready_feeature.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public PostDto createNewPost(PostDto inputPost) {
        PostEntity postEntity = modelMapper.map(inputPost,PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity),PostDto.class);
    }

    @Override
    public List<PostDto> getAllPosts() {
        return postRepository.findAll().stream().map(postEntity -> modelMapper.map(postEntity,PostDto.class)).collect(Collectors.toList());
    }
}
