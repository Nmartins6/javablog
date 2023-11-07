package com.spring.javablog.serviceImplement;

import com.spring.javablog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.javablog.repository.JavablogRepository;
import com.spring.javablog.service.JavablogService;

import java.util.List;

@Service
public class JavablogServiceImplement implements JavablogService {

    @Autowired
    JavablogRepository javablogRepository;
    @Override
    public List<Post> findAll() {
        return javablogRepository.findAll();
    }

    @Override
    public Post findById(long id) {
        return javablogRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return javablogRepository.save(post);
    }
}
