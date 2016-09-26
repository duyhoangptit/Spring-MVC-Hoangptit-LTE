package vn.hoangptit.learningframework.dto;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author hoangtd
 *         26/09/2016
 */
@Entity
@Table(name = "friend", schema = "adminlte", catalog = "")
public class FriendDto {
    private Integer id;
    private Integer customerId;
    private String fullName;
    private String phone;
    private String sdt;
    private String facebook;
    private String skyper;
    private Date birthday;
    private String description;
    private CustomerDto customer;

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
    @Column(name = "CustomerID")
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
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

        FriendDto friendDto = (FriendDto) o;

        if (id != null ? !id.equals(friendDto.id) : friendDto.id != null) return false;
        if (customerId != null ? !customerId.equals(friendDto.customerId) : friendDto.customerId != null) return false;
        if (fullName != null ? !fullName.equals(friendDto.fullName) : friendDto.fullName != null) return false;
        if (phone != null ? !phone.equals(friendDto.phone) : friendDto.phone != null) return false;
        if (sdt != null ? !sdt.equals(friendDto.sdt) : friendDto.sdt != null) return false;
        if (facebook != null ? !facebook.equals(friendDto.facebook) : friendDto.facebook != null) return false;
        if (skyper != null ? !skyper.equals(friendDto.skyper) : friendDto.skyper != null) return false;
        if (birthday != null ? !birthday.equals(friendDto.birthday) : friendDto.birthday != null) return false;
        if (description != null ? !description.equals(friendDto.description) : friendDto.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (sdt != null ? sdt.hashCode() : 0);
        result = 31 * result + (facebook != null ? facebook.hashCode() : 0);
        result = 31 * result + (skyper != null ? skyper.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }
}
