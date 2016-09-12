package vn.hoangptit.learningframework.dto;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author Hoangptit
 *         12/09/2016
 */
@Entity
public class Role {
    private int id;
    private String role;
    private Collection<RoleAccount> roleAccountsById;

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

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<RoleAccount> getRoleAccountsById() {
        return roleAccountsById;
    }

    public void setRoleAccountsById(Collection<RoleAccount> roleAccountsById) {
        this.roleAccountsById = roleAccountsById;
    }
}
