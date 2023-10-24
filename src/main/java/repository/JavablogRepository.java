package repository;

import model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JavablogRepository extends JpaRepository<Post,Long> {

}
