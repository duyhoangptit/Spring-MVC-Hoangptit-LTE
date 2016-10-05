package vn.hoangptit.learningframework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import vn.hoangptit.learningframework.dto.RoleDto;
import vn.hoangptit.learningframework.service.RoleService;

import java.util.List;

/**
 * author Hoangptit
 * Date 9/30/2016
 */
@Controller
@RequestMapping(value = "admin")
public class AdminController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "addRole", method = RequestMethod.POST)
    @ResponseBody
    public RoleDto addRole() {
        RoleDto role = new RoleDto();
        role.setNameRole("ROLE_ADMIN");
        role = roleService.saveRole(role);
        return role;
    }

    @RequestMapping(value = "findAllRoles", method = RequestMethod.GET)
    @ResponseBody
    public List<RoleDto> findAllRoles() {
        List<RoleDto> roles = roleService.findAll();
        return roles;
    }
}