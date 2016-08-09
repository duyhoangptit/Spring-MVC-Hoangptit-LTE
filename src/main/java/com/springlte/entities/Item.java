package com.springlte.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * author Hoangptit
 * Date 8/7/2016
 */

@Entity
@Table
public class Item {

    @Id
    @GeneratedValue
    private Integer itemId;
    private String title;
    @Lob
    @Column(length = Integer.MAX_VALUE)
    private String description;
    @Column(name = "published_date")
    private Date publishedDate;
    @Column(length = 1000)
    private String link;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "blog_id")
    private Blog blog;

    public Item() {
    }

    public Item(String title, String description, Date publishedDate, String link, Blog blog) {
        this.title = title;
        this.description = description;
        this.publishedDate = publishedDate;
        this.link = link;
        this.blog = blog;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
