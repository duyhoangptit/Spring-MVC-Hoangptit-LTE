package vn.hoangptit.learningframework.dto;

import javax.persistence.*;

/**
 * @author hoangtd
 *         26/09/2016
 */
@Entity
@Table(name = "role_account", schema = "adminlte")
public class RoleAccountDto {
    private Integer roleId;
    private Integer accountId;
    private RoleDto role;
    private AccountDto account;

    @Id
    @Column(name = "RoleID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Id
    @Column(name = "AccountID")
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleAccountDto that = (RoleAccountDto) o;

        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
        if (accountId != null ? !accountId.equals(that.accountId) : that.accountId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RoleID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    public RoleDto getRole() {
        return role;
    }

    public void setRole(RoleDto role) {
        this.role = role;
    }

    @ManyToOne
    @JoinColumn(name = "AccountID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    public AccountDto getAccount() {
        return account;
    }

    public void setAccount(AccountDto account) {
        this.account = account;
    }
}
