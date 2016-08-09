package com.springlte.entities;


import javax.persistence.*;
import java.util.List;


/**
 * author Hoangptit
 * Date 8/7/2016
 */
@Entity
@Table
public class Blog {

    @Id
    @GeneratedValue
    private Integer blogId;
    @Column(length = 1000)
    private String url;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private User user;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item> items;

    public Blog() {
    }

    public Blog(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public Blog(String url, String name, User user, List<Item> items) {
        this.url = url;
        this.name = name;
        this.user = user;
        this.items = items;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
