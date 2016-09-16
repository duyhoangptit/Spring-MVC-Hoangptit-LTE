package vn.hoangptit.learningframework.dao;

import java.util.List;
import java.util.Map;

/**
 * author Hoangptit
 * Date 9/14/2016
 */
public interface CrudDAO<T> {
    List<T> findAll();

    long countAll(Map<String, Object> params);

    T create(T t);

    void delete(Object id);

    T findOne(Object id);

    T update(T t);
}
