package vn.hoangptit.learningframework.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

/**
 * author Hoangptit
 * Date 9/26/2016
 */
@Entity
@Table(name = "entertain", schema = "adminlte")
public class EntertainDto extends BaseDto{
    private Integer customerId;
    private String name;
    private String description;
    private CustomerDto customer;
    private Collection<PlanDto> plans;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerID", referencedColumnName = "ID", insertable = false, updatable = false)
    @JsonIgnore
    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    @OneToMany(mappedBy = "entertain")
    public Collection<PlanDto> getPlans() {
        return plans;
    }

    public void setPlans(Collection<PlanDto> plans) {
        this.plans = plans;
    }
}
