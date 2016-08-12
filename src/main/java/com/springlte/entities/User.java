package com.springlte.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * author Hoangptit
 * Date 7/20/2016
 */

@Entity
public class User implements Serializable {

    @Id
    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "password", nullable = false, length = 60)
    private String password;
    @Column(name = "fullname", nullable = false, length = 60)
    private String fullName;
    @Column(name = "image", length = 60)
    private String image;
    @Column(name = "enabled", nullable = false)
    private boolean enabled;
    @ManyToMany
    @JoinTable
    private Set<Role> roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Blog> blogs;


    public User() {
    }

    public User(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public User(String username, String password, String fullName, String image, boolean enabled) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.image = image;
        this.enabled = enabled;
    }

    public User(String username, String password,
                boolean enabled, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
