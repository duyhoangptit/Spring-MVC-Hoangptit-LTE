package vn.hoangptit.learningframework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.hoangptit.learningframework.dao.RoleDAO;
import vn.hoangptit.learningframework.dto.RoleDto;
import vn.hoangptit.learningframework.service.RoleService;

import java.util.List;

/**
 * author Hoangptit
 * Date 9/29/2016
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public List<RoleDto> findAll() {
        return roleDAO.findAll();
    }

    @Override
    public RoleDto saveRole(RoleDto role) {
        role = roleDAO.create(role);
        return role;
    }
}
