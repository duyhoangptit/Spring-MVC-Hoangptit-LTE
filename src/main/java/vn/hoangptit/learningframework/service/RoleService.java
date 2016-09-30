package vn.hoangptit.learningframework.service;

import vn.hoangptit.learningframework.dto.RoleDto;

import java.util.List;

/**
 * author Hoangptit
 * Date 8/23/2016
 */
public interface RoleService {

    List<RoleDto> findAll();

    RoleDto saveRole(RoleDto role);
}
