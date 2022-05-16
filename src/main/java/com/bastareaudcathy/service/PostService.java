package com.bastareaudcathy.service;

import com.bastareaudcathy.entity.Post;
import com.bastareaudcathy.payload.PostDto;
import java.util.List;

public interface PostService {

  PostDto createPost (PostDto postDto);

  List<PostDto> getAllPost ();
}
