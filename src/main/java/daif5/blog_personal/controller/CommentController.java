package daif5.blog_personal.controller;

import daif5.blog_personal.model.Comment;
import daif5.blog_personal.repository.PostRepository;
import daif5.blog_personal.service.CommentService;
import daif5.blog_personal.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;
//    @GetMapping("/list")
//    public ResponseEntity<List<Comment>> getAllComment() {
//        try {
//            List<Comment> comments = commentService.findAllAndSortByDate();
//            return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
//        }
//        catch (Exception e) {
//            return new ResponseEntity<List<Comment>>(HttpStatus.NOT_FOUND);
//        }
//    }

    @PostMapping("/save")
    public ResponseEntity<List<Comment>> addComment(@RequestBody Comment comment) {
        commentService.save(comment);
        return new ResponseEntity<List<Comment>>(HttpStatus.CREATED);
    }
}
