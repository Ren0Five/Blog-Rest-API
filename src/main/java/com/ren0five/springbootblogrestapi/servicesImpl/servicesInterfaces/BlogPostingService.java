package com.ren0five.springbootblogrestapi.servicesImpl.servicesInterfaces;

import com.ren0five.springbootblogrestapi.DTOs.BlogPostDTO;
import com.ren0five.springbootblogrestapi.DTOs.BlogTitleAndAuthorDTO;
import com.ren0five.springbootblogrestapi.DTOs.EditBlogPostDTO;
import com.ren0five.springbootblogrestapi.models.BlogPost;

import java.util.List;
import java.lang.Iterable;

public interface BlogPostingService {
    public void createBlog(BlogPostDTO blogPost);

    public Iterable<BlogPost> getAllBlogs();

    public EditBlogPostDTO getBlog(long id);

    public List<BlogTitleAndAuthorDTO> getBlogsOf(String author);

    public void updateBlog(EditBlogPostDTO editBlogPostDTO);

    public void deleteBlog(long id);
}
