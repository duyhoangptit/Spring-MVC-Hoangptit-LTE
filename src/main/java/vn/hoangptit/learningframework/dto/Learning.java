package vn.hoangptit.learningframework.dto;

import javax.persistence.*;
import java.sql.Date;

/**
 * author Hoangptit
 * Date 9/10/2016
 */
@Entity
public class Learning {
    private int id;
    private String name;
    private String description;
    private Date dateLearn;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Learning learning = (Learning) o;

        if (id != learning.id) return false;
        if (name != null ? !name.equals(learning.name) : learning.name != null) return false;
        if (description != null ? !description.equals(learning.description) : learning.description != null)
            return false;
        if (dateLearn != null ? !dateLearn.equals(learning.dateLearn) : learning.dateLearn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (dateLearn != null ? dateLearn.hashCode() : 0);
        return result;
    }

    private Customer customer;

    @ManyToOne
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
