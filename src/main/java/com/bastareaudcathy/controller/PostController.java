package com.bastareaudcathy.controller;

import com.bastareaudcathy.payload.PostDto;
import com.bastareaudcathy.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {

  private PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  // Create blog post

  public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
    return  new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
  }
}
