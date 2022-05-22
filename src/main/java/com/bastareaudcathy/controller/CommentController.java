package com.bastareaudcathy.controller;


import com.bastareaudcathy.payload.CommentDto;
import com.bastareaudcathy.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts/")
public class CommentController {

  private CommentService commentService;

  public CommentController(CommentService commentService) {
    this.commentService = commentService;
  }

  @PostMapping("/posts/{postId}/comments")
  public ResponseEntity<CommentDto>createComment(@PathVariable(value = "postId") long postID,@RequestBody CommentDto commentDto){
    return new ResponseEntity<>(commentService.createComment(postID, commentDto), HttpStatus.CREATED);
  }
}
