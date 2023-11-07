package com.spring.javablog.service;

import com.spring.javablog.model.Post;

import java.util.List;

public interface JavablogService {
    List<Post> findAll();
    Post findById(long id);
    Post save(Post post);

}
