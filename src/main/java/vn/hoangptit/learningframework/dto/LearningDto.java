package vn.hoangptit.learningframework.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * author Hoangptit
 * Date 9/26/2016
 */
@Entity
@Table(name = "learning", schema = "adminlte")
public class LearningDto extends BaseDto{
    private Integer customerId;
    private String name;
    private String description;
    private Date dateLearn;
    private Collection<CategoryDto> categories;
    private CustomerDto customer;

    @Basic
    @Column(name = "CustomerID")
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "DateLearn")
    public Date getDateLearn() {
        return dateLearn;
    }

    public void setDateLearn(Date dateLearn) {
        this.dateLearn = dateLearn;
    }

    @OneToMany(mappedBy = "learning")
    public Collection<CategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(Collection<CategoryDto> categories) {
        this.categories = categories;
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
