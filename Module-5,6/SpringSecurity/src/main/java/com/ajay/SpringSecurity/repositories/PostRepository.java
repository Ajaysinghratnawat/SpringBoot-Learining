package com.ajay.SpringSecurity.repositories;

import com.ajay.SpringSecurity.entities.PostEntity2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity2, Long> {
}
