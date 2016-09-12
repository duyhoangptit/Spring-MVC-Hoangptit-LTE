package vn.hoangptit.learningframework.dto;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author Hoangptit
 *         12/09/2016
 */
@Entity
public class Friend {
    private int id;
    private int customerId;
    private String fullName;
    private String phone;
    private String sdt;
    private String facebook;
    private String skyper;
    private Date birthday;
    private String description;
    private Customer customerByCustomerId;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CustomerID")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "FullName")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "Phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "Sdt")
    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Basic
    @Column(name = "Facebook")
    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    @Basic
    @Column(name = "Skyper")
    public String getSkyper() {
        return skyper;
    }

    public void setSkyper(String skyper) {
        this.skyper = skyper;
    }

    @Basic
    @Column(name = "Birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Friend friend = (Friend) o;

        if (id != friend.id) return false;
        if (customerId != friend.customerId) return false;
        if (fullName != null ? !fullName.equals(friend.fullName) : friend.fullName != null) return false;
        if (phone != null ? !phone.equals(friend.phone) : friend.phone != null) return false;
        if (sdt != null ? !sdt.equals(friend.sdt) : friend.sdt != null) return false;
        if (facebook != null ? !facebook.equals(friend.facebook) : friend.facebook != null) return false;
        if (skyper != null ? !skyper.equals(friend.skyper) : friend.skyper != null) return false;
        if (birthday != null ? !birthday.equals(friend.birthday) : friend.birthday != null) return false;
        if (description != null ? !description.equals(friend.description) : friend.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + customerId;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (sdt != null ? sdt.hashCode() : 0);
        result = 31 * result + (facebook != null ? facebook.hashCode() : 0);
        result = 31 * result + (skyper != null ? skyper.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
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
}
