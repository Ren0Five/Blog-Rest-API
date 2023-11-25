package com.ren0five.springbootblogrestapi.controllers;


import com.ren0five.springbootblogrestapi.DTOs.BlogPostDTO;
import com.ren0five.springbootblogrestapi.DTOs.EditBlogPostDTO;
import com.ren0five.springbootblogrestapi.services.BlogPostingService;
import com.ren0five.springbootblogrestapi.session.LoggedInAccountsSessionManagement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class BlogsController {

    private final BlogPostingService blogPostingService;
    private final LoggedInAccountsSessionManagement loggedInAccountsSessionManagement;


    private BlogsController(
            BlogPostingService blogPostingService,
            LoggedInAccountsSessionManagement loggedInAccountsSessionManagement
    ){
        this.blogPostingService = blogPostingService;
        this.loggedInAccountsSessionManagement = loggedInAccountsSessionManagement;
    }

    //View blogs created by specific author
    @GetMapping("/blogs")
    public Iterable<?>viewBlogs(
            @RequestParam(required = false) String author
    ){
        Iterable<?> blogsOf = author == null ?  blogPostingService.getAllBlogs():
                                                blogPostingService.getBlogsOf(author);
        return blogsOf;
    }

    @GetMapping("/myBlogs")
    public ResponseEntity<Iterable<?>> myBlogs(){
        Iterable<?> myBlogs = blogPostingService.getBlogsOf(loggedInAccountsSessionManagement.toString());
        return ResponseEntity.status(HttpStatus.OK).body(myBlogs);
    }

    //Blogs creation
    @PostMapping("/create-blog")
    public ResponseEntity<String> publishBlog(
            @RequestBody BlogPostDTO blogPost
    ){
        if(loggedInAccountsSessionManagement.isLoggedIn()) {
            blogPost.setBlogAuthor(loggedInAccountsSessionManagement.toString());
            blogPostingService.createBlog(blogPost);
            return ResponseEntity.status(200)
                    .body("The blog is successfully created. You can view it now in the blogs section");
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Forbidden...Please Log in");
    }

    //Update Logged user's blog
    @PutMapping("/edit-blog")
    public ResponseEntity<String> editBlog(
            @RequestBody EditBlogPostDTO editBlogPostDTO
            ){
            if(loggedInAccountsSessionManagement.isLoggedIn()){
                long id = editBlogPostDTO.getBlogID();

                if(editBlogPostDTO.equals(blogPostingService.getBlog(id))) {
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                            .body("Objects have same contents so no edit will happen");
                }
                blogPostingService.updateBlog(editBlogPostDTO);
                return ResponseEntity.status(200)
                        .body("The blog is successfully updated!");
            }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Forbidden...Please Log in");
    }

    @DeleteMapping("delete-blog")
    public ResponseEntity<String> deleteBlog(
        @RequestParam long id
    ){
        if(loggedInAccountsSessionManagement.isLoggedIn()) {
            blogPostingService.deleteBlog(id);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Blog successfully deleted!");
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Forbidden...Please Log in");
    }

}
