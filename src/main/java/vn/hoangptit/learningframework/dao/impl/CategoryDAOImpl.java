package vn.hoangptit.learningframework.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import vn.hoangptit.learningframework.dto.CategoryDto;

/**
 * author Hoangptit
 * Date 9/10/2016
 */
public class CategoryDAOImpl extends CrudDAOImpl<CategoryDto>{

    private Session session;

    public CategoryDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory, CategoryDto.class);
    }
}
