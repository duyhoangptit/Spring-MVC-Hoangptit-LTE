package com.springlte.dao;


import com.springlte.entities.Account;

import java.util.List;

/**
 * author Hoangptit
 * Date 7/28/2016
 */


public interface AccountDAO {
    Account findByUsername(String username);

    Account saveUser(Account account, String role);

    List<Account> findAll();

    Account findOneWithBlogs(String username);

    void delete(int id);

}
