package com.bastareaudcathy.service;

import com.bastareaudcathy.entity.Comment;
import com.bastareaudcathy.entity.Post;
import com.bastareaudcathy.exception.ResourceNotFoundException;
import com.bastareaudcathy.payload.CommentDto;
import com.bastareaudcathy.repository.CommentRepository;
import com.bastareaudcathy.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImplementation implements CommentService{

  private CommentRepository commentRepository;
  private PostRepository postRepository;



  public CommentServiceImplementation(CommentRepository commentRepository, PostRepository postRepository) {
    this.commentRepository = commentRepository;
    this.postRepository = postRepository;
  }



  @Override
  public CommentDto createComment(long postID, CommentDto commentDto) {

    Comment comment = mapToEntity(commentDto);
    Post post = postRepository.findById(postID).orElseThrow(()-> new ResourceNotFoundException("Post", "id", postID));

    // set post to comment entity
    comment.setPost(post);

    // comment entity to database
    Comment newComment= commentRepository.save(comment);

     return  mapToDto(newComment);

  }

  private CommentDto mapToDto(Comment comment){
    CommentDto commentDto = new CommentDto();
    commentDto.setId(comment.getId());
    commentDto.setBody(comment.getBody());
    commentDto.setEmail(comment.getEmail());
    commentDto.setName(comment.getName());

    return commentDto;
  }

  private Comment mapToEntity(CommentDto commentDto) {
    Comment comment = new Comment();
    comment.setId(commentDto.getId());
    comment.setEmail(commentDto.getEmail());
    comment.setName(commentDto.getName());
    comment.setBody(commentDto.getBody());
    return comment;
  }
}
