package vn.hoangptit.learningframework.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.hoangptit.learningframework.dto.Customer;

/**
 * author Hoangptit
 * Date 9/10/2016
 */
@Transactional
@Repository
public class CustomerDAOImpl implements CustomerDAO {

    private Session session;
    private SessionFactory sessionFactory;

    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void openSession(){
        this.session = this.sessionFactory.getCurrentSession();
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public Customer getCustomer(String username) {
        return null;
    }

    @Override
    public Customer update(Customer customer) {
        return null;
    }
}
