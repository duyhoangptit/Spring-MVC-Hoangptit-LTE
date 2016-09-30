package vn.hoangptit.learningframework.dto;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * author Hoangptit
 * Date 9/26/2016
 */
@Entity
@Table(name = "customer", schema = "adminlte")
public class CustomerDto {
    private Integer id;
    private String fullName;
    private Date birthday;
    private Byte sex;
    private String description;
    private String avatar;
    private Collection<AccountDto> accounts;
    private Collection<EntertainDto> entertains;
    private Collection<FriendDto> friends;
    private Collection<LearningDto> learnings;
    private Collection<ObjectiveDto> objectives;

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
    @Column(name = "FullName")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
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

    @Basic
    @Column(name = "Avatar")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerDto that = (CustomerDto) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (avatar != null ? !avatar.equals(that.avatar) : that.avatar != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "customer")
    public Collection<AccountDto> getAccounts() {
        return accounts;
    }

    public void setAccounts(Collection<AccountDto> accounts) {
        this.accounts = accounts;
    }

    @OneToMany(mappedBy = "customer")
    public Collection<EntertainDto> getEntertains() {
        return entertains;
    }

    public void setEntertains(Collection<EntertainDto> entertains) {
        this.entertains = entertains;
    }

    @OneToMany(mappedBy = "customer")
    public Collection<FriendDto> getFriends() {
        return friends;
    }

    public void setFriends(Collection<FriendDto> friends) {
        this.friends = friends;
    }

    @OneToMany(mappedBy = "customer")
    public Collection<LearningDto> getLearnings() {
        return learnings;
    }

    public void setLearnings(Collection<LearningDto> learnings) {
        this.learnings = learnings;
    }

    @OneToMany(mappedBy = "customer")
    public Collection<ObjectiveDto> getObjectives() {
        return objectives;
    }

    public void setObjectives(Collection<ObjectiveDto> objectives) {
        this.objectives = objectives;
    }
}
