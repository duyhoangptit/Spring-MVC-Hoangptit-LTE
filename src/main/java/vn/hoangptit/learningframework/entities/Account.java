package vn.hoangptit.learningframework.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * author Hoangptit
 * Date 8/13/2016
 */
@Entity
@Table
public class Account implements Serializable {

    @Id
    @Column(unique = true, nullable = false)
    @NotEmpty
    @Size(min = 8, max = 20)
    private String username;
    @Column(nullable = false, length = 60)
    @NotEmpty
    @Size(min = 8, max = 20)
    private String password;
    @Column(length = 60)
    @NotEmpty
    @Size(min = 15, max = 30)
    private String fullName;
    @Column(length = 60)
    private String email;
    @Column(length = 60)
    private String image;
    @Column(nullable = false)
    @Min(2)
    private boolean enabled;

    @ManyToMany
    @JoinTable
    private Set<Role> roles = new HashSet<>();

    public Account() {
    }

    public Account(String username, String password, String fullName, String email, String image,
                   boolean enabled, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.image = image;
        this.enabled = enabled;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
