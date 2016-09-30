package vn.hoangptit.learningframework.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

/**
 * author Hoangptit
 * Date 9/26/2016
 */
@Entity
@Table(name = "friend", schema = "adminlte")
public class FriendDto {
    private Integer id;
    private Integer customerId;
    private String fullName;
    private String phone;
    private String email;
    private String facebook;
    private String skyper;
    private Date birthday;
    private String description;
    private String avatar;
    private Byte sex;
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
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Basic
    @Column(name = "Avatar")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "Sex")
    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
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
        if (email != null ? !email.equals(friendDto.email) : friendDto.email != null) return false;
        if (facebook != null ? !facebook.equals(friendDto.facebook) : friendDto.facebook != null) return false;
        if (skyper != null ? !skyper.equals(friendDto.skyper) : friendDto.skyper != null) return false;
        if (birthday != null ? !birthday.equals(friendDto.birthday) : friendDto.birthday != null) return false;
        if (description != null ? !description.equals(friendDto.description) : friendDto.description != null)
            return false;
        if (avatar != null ? !avatar.equals(friendDto.avatar) : friendDto.avatar != null) return false;
        if (sex != null ? !sex.equals(friendDto.sex) : friendDto.sex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (facebook != null ? facebook.hashCode() : 0);
        result = 31 * result + (skyper != null ? skyper.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerID", referencedColumnName = "ID", insertable = false, updatable = false)
    @JsonIgnore
    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }
}
