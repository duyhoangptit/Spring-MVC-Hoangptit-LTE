package vn.hoangptit.learningframework.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Hoangptit
 *         12/09/2016
 */
public class RoleAccountPK implements Serializable {
    private int roleId;
    private int accountId;

    @Column(name = "RoleID")
    @Id
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Column(name = "AccountID")
    @Id
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

        RoleAccountPK that = (RoleAccountPK) o;

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
}
