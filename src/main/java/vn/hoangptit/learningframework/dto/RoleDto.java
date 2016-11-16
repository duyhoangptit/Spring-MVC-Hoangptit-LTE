package vn.hoangptit.learningframework.dto;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * author Hoangptit
 * Date 9/26/2016
 */
@Entity
@Table(name = "role", schema = "adminlte")
public class RoleDto extends BaseDto{
    private String nameRole ;

    private List<AccountDto> accounts;

    @Basic
    @Column(name = "nameRole")
    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    public List<AccountDto> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountDto> accounts) {
        this.accounts = accounts;
    }
}
