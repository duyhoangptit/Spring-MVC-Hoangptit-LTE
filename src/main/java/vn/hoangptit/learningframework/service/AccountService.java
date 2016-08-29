package vn.hoangptit.learningframework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.hoangptit.learningframework.dao.AccountDAO;
import vn.hoangptit.learningframework.entities.Account;

import java.util.List;

/**
 * author Hoangptit
 * Date 8/23/2016
 */

@Service
@Transactional
public class AccountService implements AccountDAO {

    @Autowired
    private AccountDAO accountDAO;
    @Override
    public Account findByUsername(String username) {
        return accountDAO.findByUsername(username);
    }

    @Override
    public Account saveUser(Account account, String role) {
        return accountDAO.saveUser(account, role);
    }

    @Override
    public Account updateUser(Account account) {
        return accountDAO.updateUser(account);
    }

    @Override
    public List<Account> findAll() {
        return accountDAO.findAll();
    }

    @Override
    public Account findOneWithBlogs(String username) {
        return accountDAO.findOneWithBlogs(username);
    }

    @Override
    public void delete(int id) {
        accountDAO.delete(id);
    }
}
