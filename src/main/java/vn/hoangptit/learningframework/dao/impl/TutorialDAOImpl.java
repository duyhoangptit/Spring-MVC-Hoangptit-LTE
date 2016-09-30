package vn.hoangptit.learningframework.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import vn.hoangptit.learningframework.dao.TutorialDAO;
import vn.hoangptit.learningframework.dto.TutorialDto;

/**
 * author Hoangptit
 * Date 9/10/2016
 */
public class TutorialDAOImpl extends CrudDAOImpl<TutorialDto> implements TutorialDAO {
    private Session session;

    public TutorialDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory, TutorialDto.class);
    }
}
