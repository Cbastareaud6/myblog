package com.bastareaudcathy.service;


import com.bastareaudcathy.entity.Post;
import com.bastareaudcathy.exception.ResourceNotFoundException;
import com.bastareaudcathy.payload.PostDto;
import com.bastareaudcathy.repository.PostRepository;
import java.util.List;
import java.util.Optional;
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
    return mapToDto(post);
  }

  @Override
  public List<PostDto> getAllPost() {
    List<Post> posts = postRepository.findAll();
    return posts.stream()
        .map((post) -> mapToDto(post))
        .collect(Collectors.toList());
  }

  @Override
  public PostDto getPostById(long id) {
  Post post = postRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Post", "id", id));
  return mapToDto(post);
  }

  @Override
  public PostDto updatePost(PostDto postDto, long id) {
   Post post = new Post();
   post = postRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Post", "id", id));
   post.setDescription(postDto.getDescription());
   post.setContent(post.getContent());
   post.setTitle(postDto.getTitle());

   Post updatedPost = postRepository.save(post);
   return mapToDto(updatedPost);
  }

  @Override
  public void deletePost( long id) {
    Post post = new Post();
    post = postRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Post", "id", id));
   postRepository.delete(post);

  }


  private PostDto mapToDto(Post post) {
    PostDto postDto = new PostDto();
    postDto.setId(post.getId());
    postDto.setContent(post.getContent());
    postDto.setTitle(post.getTitle());
    postDto.setDescription(post.getDescription());

    return postDto;
  }

  private Post mapToEntity(PostDto postDto) {
    Post post = new Post();
    post.setId(postDto.getId());
    post.setContent(postDto.getContent());
    post.setTitle(postDto.getTitle());
    post.setDescription(postDto.getDescription());
    return post;
  }

}
