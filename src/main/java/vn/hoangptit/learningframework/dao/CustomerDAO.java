package vn.hoangptit.learningframework.dao;

import vn.hoangptit.learningframework.dto.CustomerDto;

/**
 * author Hoangptit
 * Date 9/10/2016
 */
public interface CustomerDAO extends CrudDAO<CustomerDto> {

    CustomerDto getCustomer(int accountId);

}
