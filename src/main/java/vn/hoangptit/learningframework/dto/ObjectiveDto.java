package vn.hoangptit.learningframework.dto;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * @author hoangtd
 *         26/09/2016
 */
@Entity
@Table(name = "objective", schema = "adminlte", catalog = "")
public class ObjectiveDto {
    private Integer id;
    private Integer customerId;
    private String title;
    private Date timeObj;
    private String description;
    private String comment;
    private Double sumObj;
    private CustomerDto customer;
    private Collection<TargetDto> targets;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObjectiveDto that = (ObjectiveDto) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (timeObj != null ? !timeObj.equals(that.timeObj) : that.timeObj != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (sumObj != null ? !sumObj.equals(that.sumObj) : that.sumObj != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (timeObj != null ? timeObj.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (sumObj != null ? sumObj.hashCode() : 0);
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

    @OneToMany(mappedBy = "objective")
    public Collection<TargetDto> getTargets() {
        return targets;
    }

    public void setTargets(Collection<TargetDto> targets) {
        this.targets = targets;
    }
}
