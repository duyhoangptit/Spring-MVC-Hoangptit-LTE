package com.springlte.dao;


import com.springlte.entities.User;

import java.util.List;

/**
 * author Hoangptit
 * Date 7/28/2016
 */


public interface UserDAO {
    User findByUsername(String username);

    User saveUser(User user);

    List<User> findAll();

    User findOneWithBlogs(String username);

    void delete(int id);

}
