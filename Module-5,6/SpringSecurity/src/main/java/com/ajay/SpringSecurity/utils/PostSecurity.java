package com.ajay.SpringSecurity.utils;

import com.ajay.SpringSecurity.dto.PostDTO;
import com.ajay.SpringSecurity.entities.PostEntity2;
import com.ajay.SpringSecurity.entities.User;
import com.ajay.SpringSecurity.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostSecurity {
    private final PostService postService;

    public boolean isOwnerOfPost(Long postId){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        PostDTO post = postService.getPostById(postId);
        return post.getAuthor().getId().equals(user.getId());
    }
}
