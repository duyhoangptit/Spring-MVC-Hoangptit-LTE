package vn.hoangptit.learningframework.service;

import vn.hoangptit.learningframework.dao.CrudDAO;
import vn.hoangptit.learningframework.dto.AccountDto;

import java.util.List;

/**
 * author Hoangptit
 * Date 8/23/2016
 */

public interface AccountService{

    AccountDto findByUsername(String username);

    AccountDto saveUser(AccountDto account, String role);

    List<AccountDto> getAllAccounts();

}
