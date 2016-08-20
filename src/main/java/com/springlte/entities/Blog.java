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

    @ManyToOne
    @JoinColumn(name = "username")
    private Account account;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Item> items;

    public Blog() {
    }

    public Blog(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public Blog(String url, String name, Account account, List<Item> items) {
        this.url = url;
        this.name = name;
        this.account = account;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
