package vn.hoangptit.learningframework.dao;


import vn.hoangptit.learningframework.dto.RoleDto;

import java.util.List;

/**
 * author Hoangptit
 * Date 8/7/2016
 */
public interface RoleDAO extends CrudDAO<RoleDto>{

    RoleDto findByName(String name);

    List<RoleDto> findAll();
}
