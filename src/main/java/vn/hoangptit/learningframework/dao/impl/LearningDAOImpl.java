package vn.hoangptit.learningframework.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import vn.hoangptit.learningframework.dao.LearningDAO;
import vn.hoangptit.learningframework.dto.LearningDto;

/**
 * author Hoangptit
 * Date 9/10/2016
 */
public class LearningDAOImpl extends CrudDAOImpl<LearningDto> implements LearningDAO {
    private Session session;

    public LearningDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory, LearningDto.class);
    }
}
