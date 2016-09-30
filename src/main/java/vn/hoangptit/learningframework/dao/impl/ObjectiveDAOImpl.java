package vn.hoangptit.learningframework.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import vn.hoangptit.learningframework.dao.ObjectiveDAO;
import vn.hoangptit.learningframework.dto.ObjectiveDto;

/**
 * author Hoangptit
 * Date 9/10/2016
 */
public class ObjectiveDAOImpl extends CrudDAOImpl<ObjectiveDto> implements ObjectiveDAO {
    private Session session;

    public ObjectiveDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory, ObjectiveDto.class);
    }
}
