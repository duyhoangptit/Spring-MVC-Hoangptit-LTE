package vn.hoangptit.learningframework.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import vn.hoangptit.learningframework.dto.TargetDto;

/**
 * author Hoangptit
 * Date 9/10/2016
 */
public class TargetDAOImpl extends CrudDAOImpl<TargetDto> {
    private Session session;

    public TargetDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory, TargetDto.class);
    }
}
