package vn.hoangptit.learningframework.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import vn.hoangptit.learningframework.dao.RoleDAO;
import vn.hoangptit.learningframework.dto.RoleDto;

import java.util.List;

/**
 * author Hoangptit
 * Date 7/28/2016
 */
@Transactional
public class RoleDAOImpl extends CrudDAOImpl<RoleDto> implements RoleDAO {

    private Session session;

    public RoleDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory, RoleDto.class);
    }

    /**
     * Không ép kiểu list về object được
     */
    @Override
    public RoleDto findByName(String name) {
        session = openSession();
        String hql = "FROM RoleDto role WHERE role.nameRole=:name";
        Query query = session.createQuery(hql);
        query.setParameter("name", name);
        List<RoleDto> roles = (List<RoleDto>) query.list();
        return roles.get(0);
    }

    @Override
    public List<RoleDto> findAll() {
        session = openSession();
        try {
            List<RoleDto> roles = session.createQuery("select role from RoleDto role").getResultList();
            return roles;
        } catch (Exception e) {
            return null;
        }
    }

}
