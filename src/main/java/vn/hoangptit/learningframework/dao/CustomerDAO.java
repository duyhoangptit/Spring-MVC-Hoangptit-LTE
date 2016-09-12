package vn.hoangptit.learningframework.dao;

import vn.hoangptit.learningframework.dto.Customer;

/**
 * author Hoangptit
 * Date 9/10/2016
 */
public interface CustomerDAO {

    Customer save(Customer customer);

    Customer getCustomer(String username);

    Customer update(Customer customer);
}
