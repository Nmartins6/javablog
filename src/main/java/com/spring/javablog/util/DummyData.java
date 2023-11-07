package com.spring.javablog.util;


import com.spring.javablog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.spring.javablog.repository.JavablogRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    JavablogRepository javablogRepository;

    //@PostConstruct
    public void savePosts(){
        System.out.println("Executou essa parada");
        List<Post> postList = new ArrayList<>();

        Post post1 = new Post();
        post1.setAuthor("Nicolas Martins");
        post1.setDate(LocalDate.now());
        post1.setTitle("Título teste");
        post1.setText("Loremrentum pellentesque dui non sagittis. Maecenas semper turpis sed quam commodo fringilla. In imperdiet.");

        Post post2 = new Post();
        post2.setAuthor("Outro Autor");
        post2.setDate(LocalDate.now());
        post2.setTitle("Título teste 2");
        post2.setText("Loremrentum pellentesque dui non sagittis. Maecenas semper turpis sed quam commodo fringilla. In imperdiet.");

        postList.add(post1);
        postList.add(post2);

        for(Post post : postList) {
            Post postSaved = javablogRepository.save(post);
            System.out.println(postSaved.getId());
        }
    }
}
