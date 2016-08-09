package com.springlte.dao;

import com.springlte.entities.Blog;
import com.springlte.entities.User;

import java.util.List;

/**
 * author Hoangptit
 * Date 8/7/2016
 */
public interface BlogDAO {

    Blog saveBlog(Blog blog);

    List<Blog> findByUser(User user);
}
