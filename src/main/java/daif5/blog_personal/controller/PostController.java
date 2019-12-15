package daif5.blog_personal.controller;

import daif5.blog_personal.model.Category;
import daif5.blog_personal.model.Picture;
import daif5.blog_personal.model.Post;
import daif5.blog_personal.model.signinSignup.User;
import daif5.blog_personal.security.services.UserDetailsServiceImpl;
import daif5.blog_personal.service.PictureService;
import daif5.blog_personal.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    PictureService pictureService;
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @GetMapping("/list")
    public ResponseEntity listPost() {
        try {
            Iterable<Post> posts = postService.findAll();
            return new ResponseEntity<Iterable<Post>>(posts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Iterable<Post>>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity addNewPost(@RequestBody Post post) {
        System.out.println("ok");
        try {
            User currentUser = userDetailsService.getCurrentUser();
           post.setUser(currentUser);
            postService.save(post);
            for (Picture picture : post.getPictures()) {
                picture.setPost(post);
                pictureService.save(picture);
            }
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        try {
            Optional<Post> post = postService.findById(id);
            return new ResponseEntity<Post>(post.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
        }
    }

//    @PutMapping("/update")
//    public ResponseEntity updatePost(@RequestBody Post post) {
//       try {
//           Optional<Post> currentPost = postService.findById(post.getId());
//           currentPost.get().setName(post.getName());
//           currentPost.get().setCategory(post.getCategory());
//           currentPost.get().setPictures(post.getPictures());
//           currentPost.get().setContent(post.getContent());
//           postService.save(currentPost.get());
//           return new ResponseEntity<Post>(currentPost.get(), HttpStatus.OK);
//    }
//       catch (Exception e) {
//           return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
//       }
//}

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity deletePost(@PathVariable Long id) {
        System.out.println("ok");
    try {
        Optional<Post> post = postService.findById(id);
         for(Picture picture: post.get().getPictures()){
           pictureService.delete(picture.getId());
          }

        postService.delete(id);

        return new ResponseEntity<Post>(HttpStatus.OK);
    }
    catch (Exception e) {
        return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
    }
    }

    @GetMapping("/getAllByCategory/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Post>> getAllByCategory(@PathVariable Long id) {
        try {
            List<Post> listPost = postService.getAllByCategoryId(id);
            return new ResponseEntity<List<Post>>(listPost, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<List<Post>>(HttpStatus.NOT_FOUND);
        }
    }

//    Function for Customer

    @GetMapping("/findAllByName")
    public ResponseEntity<List<Post>> findAllByName(@RequestParam String name) {
        try {
            List<Post> postList = postService.findAllByName(name);
            return new ResponseEntity<List<Post>>(postList, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<List<Post>>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/findAllByUser")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Post>> findAllByUser(){
        try {
            User currentUser = userDetailsService.getCurrentUser();
            List<Post> listPost = postService.getAllByUserId(currentUser.getId());
            return new ResponseEntity<List<Post>>(listPost, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<List<Post>>(HttpStatus.NOT_FOUND);

        }
    }
}
