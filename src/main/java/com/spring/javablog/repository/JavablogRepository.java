package com.spring.javablog.repository;

import com.spring.javablog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JavablogRepository extends JpaRepository<Post,Long> {

}
