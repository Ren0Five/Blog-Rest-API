package com.ren0five.springbootblogrestapi.DTOs;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Objects;

public class EditBlogPostDTO {

    @Id
    @Column("blogID")
    private long blogID;

    @Column("blogTitle")
    private String blogTitle;

    @Column("blogContent")
    private String blogContent;

    public long getBlogID() {
        return blogID;
    }

    public void setBlogID(long blogID) {
        this.blogID = blogID;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    @Override
    public boolean equals(Object o) {
        EditBlogPostDTO that = (EditBlogPostDTO) o;
        return this.blogID == that.blogID && Objects.equals(this.blogTitle, that.blogTitle) && Objects.equals(this.blogContent, that.blogContent);
    }

    @Override
    public String toString() {
        return "EditBlogPostDTO{" +
                "blogID=" + blogID +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogContent='" + blogContent + '\'' +
                '}';
    }
}
