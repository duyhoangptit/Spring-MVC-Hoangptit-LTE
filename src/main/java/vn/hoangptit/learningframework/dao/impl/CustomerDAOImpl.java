package vn.hoangptit.learningframework.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.hoangptit.learningframework.dao.CustomerDAO;
import vn.hoangptit.learningframework.dto.CustomerDto;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * author Hoangptit
 * Date 9/10/2016
 */
@Transactional
@Repository
public class CustomerDAOImpl extends CrudDAOImpl<CustomerDto> implements CustomerDAO {

    private Session session;

    public CustomerDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory, CustomerDto.class);
    }

    @Override
    public CustomerDto getCustomer(int accountId) {
        this.session  = openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<CustomerDto> cq = cb.createQuery(CustomerDto.class);
        Root<CustomerDto> from = cq.from(CustomerDto.class);
        cq.select(from);
        cq.where(cb.equal(from.get("AccountID"), accountId));
        return session.createQuery(cq).getResultList().get(0);
    }

}
