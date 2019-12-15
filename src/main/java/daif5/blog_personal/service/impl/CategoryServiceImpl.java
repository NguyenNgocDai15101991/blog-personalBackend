package daif5.blog_personal.service.impl;

import daif5.blog_personal.model.Category;
import daif5.blog_personal.repository.CategoryRepository;
import daif5.blog_personal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(Category category) {

    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Iterable<Category> findAllCategory() {
        return categoryRepository.findAll();
    }
}
