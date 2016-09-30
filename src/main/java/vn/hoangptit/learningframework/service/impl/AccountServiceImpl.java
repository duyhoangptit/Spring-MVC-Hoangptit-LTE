package vn.hoangptit.learningframework.service.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.hoangptit.learningframework.dao.AccountDAO;
import vn.hoangptit.learningframework.dao.CustomerDAO;
import vn.hoangptit.learningframework.dao.RoleDAO;
import vn.hoangptit.learningframework.dao.impl.CrudDAOImpl;
import vn.hoangptit.learningframework.dto.AccountDto;
import vn.hoangptit.learningframework.dto.CustomerDto;
import vn.hoangptit.learningframework.dto.RoleDto;
import vn.hoangptit.learningframework.service.AccountService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * author Hoangptit
 * Date 9/7/2016
 */
@Service
@Transactional
public class AccountServiceImpl  implements AccountService {
    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public AccountDto findByUsername(String username) {
        return accountDAO.findByUsername(username);
    }

    @Override
    public AccountDto saveUser(AccountDto account, String roleName) {
        // get Role
        Set<RoleDto> roles = new HashSet<>();
        RoleDto role = roleDAO.findByName(roleName);
        roles.add(role);
        // Insert customer return customerId
        CustomerDto customer = customerDAO.create(account.getCustomer());
        account.setCustomerId(customer.getId());
        // Insert Account return accountDto
        return accountDAO.saveUser(account);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        return accountDAO.findAll();
    }

}
