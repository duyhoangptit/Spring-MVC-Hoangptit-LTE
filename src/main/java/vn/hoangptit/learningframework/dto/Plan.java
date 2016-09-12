package vn.hoangptit.learningframework.dto;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * @author Hoangptit
 *         12/09/2016
 */
@Entity
public class Plan {
    private int id;
    private int entertainId;
    private Date timePlan;
    private String address;
    private double price;
    private Collection<Image> imagesById;
    private Entertain entertainByEntertainId;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "EntertainID")
    public int getEntertainId() {
        return entertainId;
    }

    public void setEntertainId(int entertainId) {
        this.entertainId = entertainId;
    }

    @Basic
    @Column(name = "TimePlan")
    public Date getTimePlan() {
        return timePlan;
    }

    public void setTimePlan(Date timePlan) {
        this.timePlan = timePlan;
    }

    @Basic
    @Column(name = "Address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "Price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plan plan = (Plan) o;

        if (id != plan.id) return false;
        if (entertainId != plan.entertainId) return false;
        if (Double.compare(plan.price, price) != 0) return false;
        if (timePlan != null ? !timePlan.equals(plan.timePlan) : plan.timePlan != null) return false;
        if (address != null ? !address.equals(plan.address) : plan.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + entertainId;
        result = 31 * result + (timePlan != null ? timePlan.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "planByPlanId")
    public Collection<Image> getImagesById() {
        return imagesById;
    }

    public void setImagesById(Collection<Image> imagesById) {
        this.imagesById = imagesById;
    }

    @ManyToOne
    @JoinColumn(name = "EntertainID", referencedColumnName = "ID", nullable = false)
    public Entertain getEntertainByEntertainId() {
        return entertainByEntertainId;
    }

    public void setEntertainByEntertainId(Entertain entertainByEntertainId) {
        this.entertainByEntertainId = entertainByEntertainId;
    }
}
