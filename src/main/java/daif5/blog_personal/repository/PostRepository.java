package daif5.blog_personal.repository;

import daif5.blog_personal.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> getAllByCategoryId(Long category_id);
    List<Post> findAllByName(String name);
    List<Post> getAllByUserId(Long id);

}
