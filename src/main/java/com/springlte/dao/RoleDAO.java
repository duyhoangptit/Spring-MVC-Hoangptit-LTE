package com.springlte.dao;

import com.springlte.entities.Role;

import java.util.List;

/**
 * author Hoangptit
 * Date 8/7/2016
 */
public interface RoleDAO {

    Role saveRole(Role role);

    Role findByName(String name);

    List<Role> findAll();
}
