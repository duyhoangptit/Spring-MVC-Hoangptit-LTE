package com.springlte.impl;

import com.springlte.dao.BlogDAO;
import com.springlte.entities.Account;
import com.springlte.entities.Blog;
import com.springlte.entities.Role;
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

    public BlogDAOImpl(SessionFactory sessionFactory) {
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
    public List<Blog> findByUser(Account account) {
        return null;
    }

    @Override
    public void findByRole(String name) {
        openSession();

        String hql = "From Role Where nameRole=:name";
        Query query = session.createQuery(hql);
        query.setParameter("name",name);

    }
}
