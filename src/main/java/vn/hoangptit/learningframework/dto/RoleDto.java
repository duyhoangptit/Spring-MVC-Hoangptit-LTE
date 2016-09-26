package vn.hoangptit.learningframework.dto;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author hoangtd
 *         26/09/2016
 */
@Entity
@Table(name = "role", schema = "adminlte", catalog = "")
public class RoleDto {
    private Integer id;
    private String role;
    private Collection<RoleAccountDto> roleAccounts;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

        RoleDto roleDto = (RoleDto) o;

        if (id != null ? !id.equals(roleDto.id) : roleDto.id != null) return false;
        if (role != null ? !role.equals(roleDto.role) : roleDto.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "role")
    public Collection<RoleAccountDto> getRoleAccounts() {
        return roleAccounts;
    }

    public void setRoleAccounts(Collection<RoleAccountDto> roleAccounts) {
        this.roleAccounts = roleAccounts;
    }
}
