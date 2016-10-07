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
    private String email;
    private Collection<AccountDto> accounts;
    private Collection<EntertainDto> entertains;
    private Collection<FriendDto> friends;
    private Collection<LearningDto> learnings;
    private Collection<ObjectiveDto> objectives;


    public void setEmail(String email) {
        this.email = email;
    }

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

    @Basic
    @Column(name = "email", nullable = true)
    public String getEmail() {
        return email;
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