package com.ren0five.springbootblogrestapi.services;

import com.ren0five.springbootblogrestapi.DTOs.BlogPostDTO;
import com.ren0five.springbootblogrestapi.DTOs.BlogTitleAndAuthorDTO;
import com.ren0five.springbootblogrestapi.DTOs.EditBlogPostDTO;
import com.ren0five.springbootblogrestapi.exceptions.NoBlogDataFoundException;
import com.ren0five.springbootblogrestapi.models.BlogPost;
import com.ren0five.springbootblogrestapi.repositories.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BlogPostingService {

    private BlogRepository blogRepository;

    public BlogPostingService(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }

    //create blog
    public void createBlog(BlogPostDTO blogPost){
        blogRepository.createBlog(
                blogPost.getBlogTitle(),
                blogPost.getBlogContent(),
                blogPost.getBlogAuthor(),
                blogPost.getDateCreated());
    }

    //read all blogs of all users
    public Iterable<BlogPost> getAllBlogs(){
        blogRepository.viewAllBlogs().forEach(s -> System.out.println(s.toString()));
        return blogRepository.viewAllBlogs();
    }
    //get single blog by its id
    public EditBlogPostDTO getBlog(long id){
        return blogRepository.getBlogPostBy(id);
    }

    //read all blogs of a logged in user
    public List<BlogTitleAndAuthorDTO> getBlogsOf(String author) {
        List<BlogTitleAndAuthorDTO>blogTitleAndAuthorDTOS = blogRepository.getAllBlogsOf(author);
        try{
          if(blogTitleAndAuthorDTOS.isEmpty())
              throw new NoBlogDataFoundException("No Blog data found, Create your first blog.");
            return blogTitleAndAuthorDTOS;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching blog data", e);
        }
    }

    //update the blog of the logged-in user
    public void updateBlog(EditBlogPostDTO editBlogPostDTO){
        blogRepository.editBlog(
                editBlogPostDTO.getBlogTitle(),
                editBlogPostDTO.getBlogContent(),
                editBlogPostDTO.getBlogID()
        );
    }

    //delete the blog of the logged-in user
    @Transactional
    public void deleteBlog(long id){
        blogRepository.deleteBlogPostBy(id);
    }





}
