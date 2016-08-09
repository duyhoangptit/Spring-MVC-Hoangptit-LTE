package com.springlte.impl;

import com.springlte.dao.RoleDAO;
import com.springlte.dao.UserDAO;
import com.springlte.entities.Role;
import com.springlte.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author Hoangptit
 * Date 7/28/2016
 */
@Transactional
public class RoleDAOImpl implements RoleDAO {

    private Session session;
    private SessionFactory sessionFactory;

    private RoleDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private void openSession() {
        session = sessionFactory.getCurrentSession();
    }


    @Override
    public Role saveRole(Role role) {
        openSession();
        session.save(role);
        return role;
    }

    @Override
    public Role findByName(String name) {
        openSession();
        Role role = (Role)session.createQuery("from Role where name='"+name+"'").uniqueResult();
        return role;
    }
}
