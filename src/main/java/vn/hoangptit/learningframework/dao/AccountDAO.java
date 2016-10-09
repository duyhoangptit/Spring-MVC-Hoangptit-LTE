package vn.hoangptit.learningframework.dao;



import vn.hoangptit.learningframework.dto.AccountDto;

import java.util.List;

/**
 * author Hoangptit
 * Date 7/28/2016
 */


public interface AccountDAO extends CrudDAO<AccountDto> {

    AccountDto findByUsername(String username);

    List<AccountDto> findAll();

}
