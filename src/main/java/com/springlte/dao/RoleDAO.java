package com.springlte.dao;

import com.springlte.entities.Role;

/**
 * author Hoangptit
 * Date 8/7/2016
 */
public interface RoleDAO {

    Role saveRole(Role role);

    Role findByName(String name);
}
