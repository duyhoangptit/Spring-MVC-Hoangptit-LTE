package vn.hoangptit.learningframework.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import vn.hoangptit.learningframework.dao.CrudDAO;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Map;

/**
 * author Hoangptit
 * Date 9/14/2016
 */
public class CrudDAOImpl<T> implements CrudDAO<T> {

    private Session session;
    private SessionFactory sessionFactory;
    private Class<T> clazz;

    public CrudDAOImpl(SessionFactory sessionFactory, Class<T> clazz) {
        this.sessionFactory = sessionFactory;
        this.clazz = clazz;
    }

    public Session openSession() {
        this.session = sessionFactory.getCurrentSession();
        return this.session;
    }

    @Override
    public long countAll(Map<String, Object> maps) {
        openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        cq.select(cb.count(cq.from(Object.class)));
        return session.createQuery(cq).getSingleResult();
    }

    @Override
    public T create(T t) {
        openSession();
        session.save(t);
        return t;
    }

    @Override
    public void delete(T t) {
        openSession();
        session.delete(t);
    }

    @Override
    public T findOne(Integer id) {
        openSession();
        T t = session.get(clazz,id);
        return t;
    }

    @Override
    public T update(T t) {
        openSession();
        session.update(t);
        return t;
    }
}
