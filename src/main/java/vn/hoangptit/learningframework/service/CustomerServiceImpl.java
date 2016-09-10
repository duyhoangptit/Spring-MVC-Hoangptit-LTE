package vn.hoangptit.learningframework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.hoangptit.learningframework.dao.CustomerDAO;
import vn.hoangptit.learningframework.dto.Customer;

/**
 * author Hoangptit
 * Date 9/10/2016
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

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
