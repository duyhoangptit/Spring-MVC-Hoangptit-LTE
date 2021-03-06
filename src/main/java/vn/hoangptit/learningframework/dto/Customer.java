package vn.hoangptit.learningframework.dto;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * @author Hoangptit
 *         12/09/2016
 */
@Entity
public class Customer {
    private int id;
    private String fullName;
    private String avatar;
    private Date birthday;
    private byte sex;
    private String description;
    private Collection<Account> accountsById;
    private Collection<Entertain> entertainsById;
    private Collection<Friend> friendsById;
    private Collection<Learning> learningsById;
    private Collection<Objective> objectivesById;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "Avatar")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
    @Column(name = "Sex")
    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
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

        Customer customer = (Customer) o;

        if (id != customer.id) return false;
        if (sex != customer.sex) return false;
        if (fullName != null ? !fullName.equals(customer.fullName) : customer.fullName != null) return false;
        if (avatar != null ? !avatar.equals(customer.avatar) : customer.avatar != null) return false;
        if (birthday != null ? !birthday.equals(customer.birthday) : customer.birthday != null) return false;
        if (description != null ? !description.equals(customer.description) : customer.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (int) sex;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<Account> getAccountsById() {
        return accountsById;
    }

    public void setAccountsById(Collection<Account> accountsById) {
        this.accountsById = accountsById;
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<Entertain> getEntertainsById() {
        return entertainsById;
    }

    public void setEntertainsById(Collection<Entertain> entertainsById) {
        this.entertainsById = entertainsById;
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<Friend> getFriendsById() {
        return friendsById;
    }

    public void setFriendsById(Collection<Friend> friendsById) {
        this.friendsById = friendsById;
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<Learning> getLearningsById() {
        return learningsById;
    }

    public void setLearningsById(Collection<Learning> learningsById) {
        this.learningsById = learningsById;
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<Objective> getObjectivesById() {
        return objectivesById;
    }

    public void setObjectivesById(Collection<Objective> objectivesById) {
        this.objectivesById = objectivesById;
    }
}
