package vn.hoangptit.learningframework.dto;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author Hoangptit
 *         12/09/2016
 */
@Entity
public class Account {
    private int id;
    private String username;
    private String password;
    private byte enable;
    private int customerId;
    private Customer customerByCustomerId;
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
    @Column(name = "Username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "Enable")
    public byte getEnable() {
        return enable;
    }

    public void setEnable(byte enable) {
        this.enable = enable;
    }

    @Basic
    @Column(name = "CustomerID")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != account.id) return false;
        if (enable != account.enable) return false;
        if (customerId != account.customerId) return false;
        if (username != null ? !username.equals(account.username) : account.username != null) return false;
        if (password != null ? !password.equals(account.password) : account.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (int) enable;
        result = 31 * result + customerId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "ID", nullable = false)
    public Customer getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }

    @OneToMany(mappedBy = "accountByAccountId")
    public Collection<RoleAccount> getRoleAccountsById() {
        return roleAccountsById;
    }

    public void setRoleAccountsById(Collection<RoleAccount> roleAccountsById) {
        this.roleAccountsById = roleAccountsById;
    }
}
