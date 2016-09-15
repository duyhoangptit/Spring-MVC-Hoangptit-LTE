package vn.hoangptit.learningframework.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import vn.hoangptit.learningframework.dao.RoleDAO;
import vn.hoangptit.learningframework.entities.Role;

import java.util.List;

/**
 * author Hoangptit
 * Date 7/28/2016
 */
@Transactional
public class RoleDAOImpl implements RoleDAO {

    private Session session;
    private SessionFactory sessionFactory;

    public RoleDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private void openSession() {
        this.session = this.sessionFactory.getCurrentSession();
    }


    @Override
    public Role saveRole(Role role) {
        openSession();
        session.save(role);
        return role;
    }

    /**
     * Không ép kiểu list về object được
     * */
    @Override
    public Role findByName(String name) {
        openSession();
        String hql = "FROM Role role WHERE role.nameRole=:name";
        Query query = session.createQuery(hql);
        query.setParameter("name",name);
        List<Role> roles = (List<Role>)query.list();
        return roles.get(0);
    }

    @Override
    public List<Role> findAll() {
        openSession();
        List<Role> roles = session.createQuery("from Role").list();
        return roles;
    }
}
