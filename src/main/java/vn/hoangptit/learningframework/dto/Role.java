package vn.hoangptit.learningframework.dto;

import vn.hoangptit.learningframework.entities.*;
import vn.hoangptit.learningframework.entities.Account;

import javax.persistence.*;
import java.util.List;

/**
 * author Hoangptit
 * Date 9/10/2016
 */
@Entity
public class Role {
    private int id;
    private String role;
    @ManyToMany(mappedBy = "roles")
    private List<Account> accounts;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role1 = (Role) o;

        if (id != role1.id) return false;
        if (role != null ? !role.equals(role1.role) : role1.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

}
