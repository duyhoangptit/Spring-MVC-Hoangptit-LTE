package vn.hoangptit.learningframework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.hoangptit.learningframework.dao.CustomerDAO;
import vn.hoangptit.learningframework.service.CustomerService;

/**
 * author Hoangptit
 * Date 9/10/2016
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

}
