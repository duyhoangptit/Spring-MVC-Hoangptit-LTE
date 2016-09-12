package vn.hoangptit.learningframework.dto;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * @author Hoangptit
 *         12/09/2016
 */
@Entity
public class Objective {
    private int id;
    private int customerId;
    private String title;
    private Date timeObj;
    private String description;
    private String comment;
    private double sumObj;
    private Customer customerByCustomerId;
    private Collection<Target> targetsById;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CustomerID")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
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
    public double getSumObj() {
        return sumObj;
    }

    public void setSumObj(double sumObj) {
        this.sumObj = sumObj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Objective objective = (Objective) o;

        if (id != objective.id) return false;
        if (customerId != objective.customerId) return false;
        if (Double.compare(objective.sumObj, sumObj) != 0) return false;
        if (title != null ? !title.equals(objective.title) : objective.title != null) return false;
        if (timeObj != null ? !timeObj.equals(objective.timeObj) : objective.timeObj != null) return false;
        if (description != null ? !description.equals(objective.description) : objective.description != null)
            return false;
        if (comment != null ? !comment.equals(objective.comment) : objective.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + customerId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (timeObj != null ? timeObj.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        temp = Double.doubleToLongBits(sumObj);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "ID", nullable = false)
    public Customer getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }

    @OneToMany(mappedBy = "objectiveByObjectiveId")
    public Collection<Target> getTargetsById() {
        return targetsById;
    }

    public void setTargetsById(Collection<Target> targetsById) {
        this.targetsById = targetsById;
    }
}
