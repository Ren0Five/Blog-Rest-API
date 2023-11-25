package com.ren0five.springbootblogrestapi.repositories;


import com.ren0five.springbootblogrestapi.DTOs.BlogTitleAndAuthorDTO;
import com.ren0five.springbootblogrestapi.DTOs.EditBlogPostDTO;
import com.ren0five.springbootblogrestapi.models.BlogPost;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface BlogRepository extends CrudRepository<BlogPost, Long> {

    //Create queries
    @Modifying
    @Query("INSERT INTO blogs (blogTitle, blogContent, blogAuthor, datePublished) VALUES(:blogTitle, :blogContent, :blogAuthor, :dateCreated)")
    void createBlog(String blogTitle, String blogContent, String blogAuthor, Date dateCreated);

    //Read queries
    @Query("SELECT blogTitle, blogAuthor, datePublished FROM blogs WHERE blogAuthor = :author")
    List<BlogTitleAndAuthorDTO> getAllBlogsOf(String author);
    @Query("SELECT * FROM blogs")
    Iterable<BlogPost> viewAllBlogs();
    @Query("SELECT * FROM blogs WHERE blogID = :blogID")
    EditBlogPostDTO getBlogPostBy(long blogID);

    //Update queries
    @Modifying
    @Query("UPDATE blogs SET blogTitle = :blogTitle, blogContent = :blogContent WHERE blogID = :blogID")
    void editBlog(String blogTitle, String blogContent, long blogID);

    //Delete queries
    @Modifying
    @Query("DELETE  FROM BLOGS WHERE blogID = :id")
    boolean deleteBlogPostBy(long id);
}


