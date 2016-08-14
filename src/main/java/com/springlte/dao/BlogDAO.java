package com.springlte.dao;

import com.springlte.entities.Account;
import com.springlte.entities.Blog;

import java.util.List;

/**
 * author Hoangptit
 * Date 8/7/2016
 */
public interface BlogDAO {

    Blog saveBlog(Blog blog);

    List<Blog> findByUser(Account account);

    void findByRole(String name);
}
