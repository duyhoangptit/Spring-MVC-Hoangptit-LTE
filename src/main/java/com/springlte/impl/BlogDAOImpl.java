package com.springlte.impl;

import com.springlte.dao.BlogDAO;
import com.springlte.entities.Blog;
import com.springlte.entities.Role;
import com.springlte.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author Hoangptit
 * Date 7/28/2016
 */
@Transactional
public class BlogDAOImpl implements BlogDAO {

    private Session session;
    private SessionFactory sessionFactory;

    private BlogDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private void openSession() {
        session = sessionFactory.getCurrentSession();
    }

    @Override
    public Blog saveBlog(Blog blog) {
        openSession();
        session.save(blog);
        return blog;
    }

    @Override
    public List<Blog> findByUser(User user) {
        return null;
    }

    @Override
    public void findByRole(String name) {
        openSession();

        String hql = "From Role Where name=:name";
        Query query = session.createQuery(hql);
        query.setParameter("name",name);

    }
}
