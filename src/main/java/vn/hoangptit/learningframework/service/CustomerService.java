package vn.hoangptit.learningframework.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.hoangptit.learningframework.dao.CustomerDAO;
import vn.hoangptit.learningframework.dto.AccountDto;
import vn.hoangptit.learningframework.dto.FriendDto;

import java.util.List;

/**
 * author Hoangptit
 * Date 9/10/2016
 */

public interface CustomerService {

    List<FriendDto> findAllFriends(Integer customerId);

    AccountDto updateAccount(AccountDto accountDto);

    FriendDto addFriend(FriendDto friendDto);

}
