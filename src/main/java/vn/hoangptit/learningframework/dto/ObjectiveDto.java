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
@Table(name = "objective", schema = "adminlte")
public class ObjectiveDto extends BaseDto{
    private Integer customerId;
    private String title;
    private Date timeObj;
    private String description;
    private String comment;
    private Double sumObj;
    private CustomerDto customer;
    private Collection<TargetDto> targets;

    @Basic
    @Column(name = "CustomerID")
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "TimeObj")
    public Date getTimeObj() {
        return timeObj;
    }

    public void setTimeObj(Date timeObj) {
        this.timeObj = timeObj;
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
    @Column(name = "Comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "SumObj")
    public Double getSumObj() {
        return sumObj;
    }

    public void setSumObj(Double sumObj) {
        this.sumObj = sumObj;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerID", referencedColumnName = "ID",  insertable = false, updatable = false)
    @JsonIgnore
    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    @OneToMany(mappedBy = "objective")
    public Collection<TargetDto> getTargets() {
        return targets;
    }

    public void setTargets(Collection<TargetDto> targets) {
        this.targets = targets;
    }
}
