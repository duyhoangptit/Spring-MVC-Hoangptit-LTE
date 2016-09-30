package vn.hoangptit.learningframework.dao;

import vn.hoangptit.learningframework.dto.FriendDto;

import java.util.List;

/**
 * author Hoangptit
 * Date 9/10/2016
 */
public interface FriendDAO extends CrudDAO<FriendDto> {
    List<FriendDto> findFriendsById(Integer customerId);
}
