package com.isaachome.springdocker.controller;

import com.isaachome.springdocker.model.Post;
import com.isaachome.springdocker.repository.PostRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/api/posts")
public class PostController {
    private  final PostRepo postRepo;


    public PostController(PostRepo postRepo) {
        this.postRepo = postRepo;
    }
    @GetMapping
    public List<Post> findAll(){
        return Arrays.asList(new Post("Title 1","Body 1"),new Post("Title 2","Body 2"));
//        return  postRepo.findAll();
    }
}
