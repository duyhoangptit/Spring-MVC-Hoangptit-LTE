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
public class RoleDto {
    private Integer id;
    private String nameRole ;

    private List<AccountDto> accounts;

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
