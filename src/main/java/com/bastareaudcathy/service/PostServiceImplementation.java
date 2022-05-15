package com.bastareaudcathy.service;


import com.bastareaudcathy.entity.Post;
import com.bastareaudcathy.payload.PostDto;
import com.bastareaudcathy.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImplementation implements PostService {

  private PostRepository postRepository;

  @Autowired
  public PostServiceImplementation(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @Override
  public PostDto createPost(PostDto postDto) {
    Post post = new Post();
    post.setContent(postDto.getContent());
    post.setTitle(postDto.getTitle());
    post.setDescription(postDto.getDescription());

    Post newPost = postRepository.save(post);

    PostDto postResponse = new PostDto();
    postResponse.setId(newPost.getId());
    postResponse.setContent(newPost.getContent());
    postResponse.setTitle(newPost.getTitle());
    postResponse.setDescription(newPost.getDescription());


    return postResponse;
  }
}
