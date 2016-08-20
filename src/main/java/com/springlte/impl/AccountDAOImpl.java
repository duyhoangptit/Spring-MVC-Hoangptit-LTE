package com.springlte.impl;

import com.springlte.dao.BlogDAO;
import com.springlte.dao.ItemDAO;
import com.springlte.dao.RoleDAO;
import com.springlte.dao.AccountDAO;
import com.springlte.entities.Account;
import com.springlte.entities.Blog;
import com.springlte.entities.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * author Hoangptit
 * Date 7/28/2016
 */
@Transactional
public class AccountDAOImpl implements AccountDAO {

    @Autowired
    private BlogDAO blogDAO;
    @Autowired
    private ItemDAO itemDAO;
    @Autowired
    private RoleDAO roleDAO;

    private Session session;
    private SessionFactory sessionFactory;

    public AccountDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private void openSession() {
        this.session = this.sessionFactory.getCurrentSession();
    }

    @Override
    public Account findByUsername(String username) {
        openSession();
        Account user;
        List<Account> users = session.
                createQuery("from Account where username = ?").
                setParameter(0, username).
                list();// truyền câu lệnh query + setParameter + lấy về list
        if (users.size() > 0) {
            user = users.get(0);
            return user;
        }
        return null;
    }

    @Override
    public Account saveUser(Account account, String roleUser) {
        openSession();

        Set<Role> roles = new HashSet<>();
        Role role = roleDAO.findByName(roleUser);
        roles.add(role);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        account.setPassword(encoder.encode(account.getPassword()));
        account.setRoles(roles);

        session.save(account);
        return account;
    }

    @Override
    public List<Account> findAll() {
        openSession();
        List<Account> accounts = session.createQuery("FROM Account ").list();
        return accounts;
    }

    @Override
    public Account findOneWithBlogs(String username) {
        Account account = findByUsername(username);
        List<Blog> blogs = blogDAO.findByUser(account);
        for(Blog blog : blogs){
//            List<Item> items  = itemDAO.findByBlog(blog, new PageRequest(0, 10, Sort.Direction.DESC, "publishedDate"));
//            blog.setItems(items);
        }
        account.setBlogs(blogs);
        return account;
    }

    @Override
    public void delete(int userId) {
        openSession();
        Account account = (Account)session.get(Account.class, userId);
        session.delete(account);
    }

}
