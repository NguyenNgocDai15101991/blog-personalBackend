package daif5.blog_personal.service;

import daif5.blog_personal.model.Category;

import java.util.Optional;

public interface CategoryService {
    void save(Category category);
    void delete(Long id);
    void delete(Category category);
    Optional<Category> findById(Long id);
    Iterable<Category> findAllCategory();

}
