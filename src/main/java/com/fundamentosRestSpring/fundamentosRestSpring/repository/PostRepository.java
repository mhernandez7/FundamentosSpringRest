package com.fundamentosRestSpring.fundamentosRestSpring.repository;

import com.fundamentosRestSpring.fundamentosRestSpring.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
