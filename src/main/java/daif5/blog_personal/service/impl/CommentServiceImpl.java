package daif5.blog_personal.service.impl;

import daif5.blog_personal.model.Comment;
import daif5.blog_personal.repository.CommentRepository;
import daif5.blog_personal.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }
}
