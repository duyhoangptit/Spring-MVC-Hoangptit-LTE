package com.springlte.impl;

import com.springlte.dao.BlogDAO;
import com.springlte.dao.ItemDAO;
import com.springlte.dao.RoleDAO;
import com.springlte.dao.UserDAO;
import com.springlte.entities.Blog;
import com.springlte.entities.Item;
import com.springlte.entities.Role;
import com.springlte.entities.User;
import com.springlte.until.ConfigUntil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * author Hoangptit
 * Date 7/28/2016
 */
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    private BlogDAO blogDAO;
    @Autowired
    private ItemDAO itemDAO;
    @Autowired
    private RoleDAO roleDAO;

    private Session session;
    private SessionFactory sessionFactory;

    private UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private void openSession() {
        session = sessionFactory.getCurrentSession();
    }

    @Override
    public User findByUsername(String username) {
        openSession();
        User user;
        List<User> users = session.
                createQuery("from User where username = ?").
                setParameter(0, username).
                list();// truyền câu lệnh query + setParameter + lấy về list
        if (users.size() > 0) {
            user = users.get(0);
            return user;
        }
        return null;
    }

    @Override
    public User saveUser(User user) {
        openSession();
        user.setEnabled(true);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));

        Set<Role> roles  = new HashSet<>();
        roles.add(roleDAO.findByName("ROLE_USER"));
        user.setRoles(roles);
        session.save(user);
        return user;
    }

    @Override
    public List<User> findAll() {
        openSession();
        List<User> users = session.createQuery("FROM User ").list();
        return users;
    }

    @Override
    public User findOneWithBlogs(String username) {
        User user = findByUsername(username);
        List<Blog> blogs = blogDAO.findByUser(user);
        for(Blog blog : blogs){
//            List<Item> items  = itemDAO.findByBlog(blog, new PageRequest(0, 10, Sort.Direction.DESC, "publishedDate"));
//            blog.setItems(items);
        }
        user.setBlogs(blogs);
        return user;
    }

    @Override
    public void delete(int userId) {
        openSession();
        User user = (User)session.get(User.class, userId);
        session.delete(user);
    }

}
