package com.springlte.impl;

import com.springlte.dao.ItemDAO;
import com.springlte.dao.RoleDAO;
import com.springlte.entities.Blog;
import com.springlte.entities.Item;
import com.springlte.entities.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

/**
 * author Hoangptit
 * Date 7/28/2016
 */
@Transactional
public class ItemDAOImpl implements ItemDAO {

    private Session session;
    private SessionFactory sessionFactory;

    public ItemDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private void openSession() {
        session = sessionFactory.getCurrentSession();
    }

    @Override
    public Item saveItem(Item item) {
        openSession();
        session.save(item);
        return item;
    }

    @Override
    public List<Item> findByBlog(Blog blog, Pageable pageable) {
        List<Item> items = new ArrayList<>();
        return items;
    }

    @Override
    public Item findByBlogAndLink(Blog blog, String link) {
        return null;
    }
}
