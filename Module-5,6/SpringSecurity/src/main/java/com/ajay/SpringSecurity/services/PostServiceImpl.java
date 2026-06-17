package com.ajay.SpringSecurity.services;

import com.ajay.SpringSecurity.dto.PostDTO;
import com.ajay.SpringSecurity.entities.PostEntity2;
import com.ajay.SpringSecurity.exceptions.ResourceNotFoundException;
import com.ajay.SpringSecurity.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service @RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository
                .findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity, PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO createNewPost(PostDTO inputPost) {
        PostEntity2 postEntity = modelMapper.map(inputPost, PostEntity2.class);
        return modelMapper.map(postRepository.save(postEntity), PostDTO.class);
    }

    @Override
    public PostDTO getPostById(Long postId) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        log.info("User {}",user);
        PostEntity2 postEntity = postRepository
                .findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id "+postId));
        return modelMapper.map(postEntity, PostDTO.class);
    }
}
