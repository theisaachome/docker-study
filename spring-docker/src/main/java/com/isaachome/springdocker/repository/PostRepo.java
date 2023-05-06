package com.isaachome.springdocker.repository;

import com.isaachome.springdocker.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Integer> {
}
