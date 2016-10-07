package vn.hoangptit.learningframework.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import vn.hoangptit.learningframework.dao.FriendDAO;
import vn.hoangptit.learningframework.dto.FriendDto;

import java.util.List;

/**
 * author Hoangptit
 * Date 9/10/2016
 */
public class FriendDAOImpl extends CrudDAOImpl<FriendDto> implements FriendDAO {

    private Session session;

    public FriendDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory, FriendDto.class);
    }

    @Override
    public List<FriendDto> findFriendsById(Integer customerId) {
        return null;
    }
}