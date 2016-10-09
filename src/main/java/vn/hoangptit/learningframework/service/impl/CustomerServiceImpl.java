package vn.hoangptit.learningframework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.hoangptit.learningframework.dao.AccountDAO;
import vn.hoangptit.learningframework.dao.CustomerDAO;
import vn.hoangptit.learningframework.dao.FriendDAO;
import vn.hoangptit.learningframework.dto.AccountDto;
import vn.hoangptit.learningframework.dto.FriendDto;
import vn.hoangptit.learningframework.service.CustomerService;
import vn.hoangptit.learningframework.utils.ConfigUntil;

import java.util.List;

/**
 * author Hoangptit
 * Date 9/10/2016
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private FriendDAO friendDAO;

    public List<FriendDto> findAllFriends(Integer customerId) {
        List<FriendDto> friends = friendDAO.findFriendsById(customerId);
        return friends;
    }

    public AccountDto updateAccount(AccountDto account) {
        account.setPassword(ConfigUntil.encode(account.getPassword()));
        account = accountDAO.update(account);
        return account;
    }

    @Override
    public FriendDto addFriend(FriendDto friendDto) {
        friendDAO.create(friendDto);
        return friendDto;
    }

}
