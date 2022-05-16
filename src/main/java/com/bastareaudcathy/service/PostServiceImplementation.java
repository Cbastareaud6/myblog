package com.bastareaudcathy.service;


import com.bastareaudcathy.entity.Post;
import com.bastareaudcathy.payload.PostDto;
import com.bastareaudcathy.repository.PostRepository;
import java.util.List;
import java.util.stream.Collectors;
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
    Post post = mapToEntity(postDto);
    Post newPost = postRepository.save(post);
    PostDto postResponse = mapToDto(post);
    return postResponse;
  }

  @Override
  public List<PostDto> getAllPost() {
    List<Post> posts = postRepository.findAll();
    return posts.stream()
        .map((post) -> mapToDto(post))
        .collect(Collectors.toList());

  }

  private PostDto mapToDto(Post post) {
    PostDto postDto = new PostDto();
    postDto.setContent(post.getContent());
    postDto.setTitle(post.getTitle());
    postDto.setDescription(post.getDescription());

    return postDto;
  }

  private Post mapToEntity(PostDto postDto) {
    Post post = new Post();
    post.setContent(postDto.getContent());
    post.setTitle(postDto.getTitle());
    post.setDescription(postDto.getDescription());
    return post;
  }

}
