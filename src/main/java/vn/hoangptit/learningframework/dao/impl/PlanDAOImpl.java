package vn.hoangptit.learningframework.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import vn.hoangptit.learningframework.dao.PlanDAO;
import vn.hoangptit.learningframework.dto.PlanDto;

/**
 * author Hoangptit
 * Date 9/10/2016
 */
public class PlanDAOImpl extends CrudDAOImpl<PlanDto> implements PlanDAO{
    private Session session;

    public PlanDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory, PlanDto.class);
    }
}
