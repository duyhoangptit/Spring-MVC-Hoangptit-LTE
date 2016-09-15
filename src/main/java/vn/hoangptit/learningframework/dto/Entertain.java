package vn.hoangptit.learningframework.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author Hoangptit
 *         12/09/2016
 */
@Entity
public class Entertain {
    private int id;
    private int customerId;
    private String name;
    private String description;
    private Customer customerByCustomerId;
    private Collection<Plan> plenById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entertain entertain = (Entertain) o;

        if (id != entertain.id) return false;
        if (customerId != entertain.customerId) return false;
        if (name != null ? !name.equals(entertain.name) : entertain.name != null) return false;
        if (description != null ? !description.equals(entertain.description) : entertain.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + customerId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "ID", nullable = false)
    // khi đứng ở customer lấy ra list entertain thì k cần lấy customer ra nữa
    @JsonIgnore
    public Customer getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }

    @OneToMany(mappedBy = "entertainByEntertainId")
    public Collection<Plan> getPlenById() {
        return plenById;
    }

    public void setPlenById(Collection<Plan> plenById) {
        this.plenById = plenById;
    }
}
