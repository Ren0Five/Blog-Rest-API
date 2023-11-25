package com.ren0five.springbootblogrestapi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;

@Table("blogs")
public class BlogPost {

    @Id
    @Column("blogID")
    private long blogID;
    @Column("blogTitle")
    private String blogTitle;

    @Column("blogContent")
    private String blogContent;

    @Column("blogAuthor")

    private String blogAuthor;

    @Column("datePublished")
    private Date dateCreated;

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

    @Override
    public String toString() {
        return "BlogPost{" +
                "blogID=" + blogID +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogContent='" + blogContent + '\'' +
                ", blogAuthor='" + blogAuthor + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }

}
