package vn.hoangptit.learningframework.dto;

import javax.persistence.*;

/**
 * @author Hoangptit
 *         12/09/2016
 */
@Entity
@Table(name = "role_account", schema = "adminlte", catalog = "")
@IdClass(RoleAccountPK.class)
public class RoleAccount {
    private int roleId;
    private int accountId;
    private Role roleByRoleId;
    private Account accountByAccountId;

    @Id
    @Column(name = "RoleID")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Id
    @Column(name = "AccountID")
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleAccount that = (RoleAccount) o;

        if (roleId != that.roleId) return false;
        if (accountId != that.accountId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + accountId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "RoleID", referencedColumnName = "ID", nullable = false)
    public Role getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(Role roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }

    @ManyToOne
    @JoinColumn(name = "AccountID", referencedColumnName = "ID", nullable = false)
    public Account getAccountByAccountId() {
        return accountByAccountId;
    }

    public void setAccountByAccountId(Account accountByAccountId) {
        this.accountByAccountId = accountByAccountId;
    }
}
