package com.ren0five.springbootblogrestapi.DTOs;

import org.springframework.data.relational.core.mapping.Column;

import java.sql.Date;

public class BlogTitleAndAuthorDTO {
    @Column("blogTitle")
    private String blogTitle;

    @Column("blogAuthor")
    private String blogAuthor;

    @Column("datePublished")
    private Date dateCreated;

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogAuthor() {
        return blogAuthor;
    }

    public void setBlogAuthor(String blogAuthor) {
        this.blogAuthor = blogAuthor;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
