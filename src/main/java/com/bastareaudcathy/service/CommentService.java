package com.bastareaudcathy.service;

import com.bastareaudcathy.payload.CommentDto;
import org.springframework.stereotype.Service;


public interface CommentService {

  CommentDto createComment(long postID, CommentDto commentDto);

}
