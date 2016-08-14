package com.springlte.entities;

import javax.persistence.*;
import java.util.List;

/**
 * author Hoangptit
 * Date 8/7/2016
 */

@Entity
@Table
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    private String nameRole;

    @ManyToMany(mappedBy = "roles")
    private List<Account> accounts;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public List<Account> getUsers() {
        return accounts;
    }

    public void setUsers(List<Account> users) {
        this.accounts = users;
    }
}
