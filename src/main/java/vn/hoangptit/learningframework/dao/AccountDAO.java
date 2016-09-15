package vn.hoangptit.learningframework.dao;


import vn.hoangptit.learningframework.entities.Account;

import java.util.List;

/**
 * author Hoangptit
 * Date 7/28/2016
 */


public interface AccountDAO extends CrudDAO<Account> {

    Account findByUsername(String username);

    Account saveUser(Account account, String role);

    Account updateUser(Account account);

    List<Account> findAll();

    Account findOneWithBlogs(String username);

    void delete(int id);

}
