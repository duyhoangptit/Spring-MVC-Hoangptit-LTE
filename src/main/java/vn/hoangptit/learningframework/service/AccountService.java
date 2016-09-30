package vn.hoangptit.learningframework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.hoangptit.learningframework.dao.AccountDAO;
import vn.hoangptit.learningframework.entities.Account;

import java.util.List;

/**
 * author Hoangptit
 * Date 8/23/2016
 */

public interface AccountService {

    Account findByUsername(String username);

    Account saveUser(Account account, String role);

    Account updateUser(Account account);

    List<Account> findAll();

}
