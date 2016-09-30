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
@Table(name = "plan", schema = "adminlte", catalog = "")
public class PlanDto {
    private Integer id;
    private Integer entertainId;
    private Date timePlan;
    private String address;
    private Double price;
    private Collection<ImageDto> images;
    private EntertainDto entertain;

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
    @Column(name = "EntertainID")
    public Integer getEntertainId() {
        return entertainId;
    }

    public void setEntertainId(Integer entertainId) {
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
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlanDto planDto = (PlanDto) o;

        if (id != null ? !id.equals(planDto.id) : planDto.id != null) return false;
        if (entertainId != null ? !entertainId.equals(planDto.entertainId) : planDto.entertainId != null) return false;
        if (timePlan != null ? !timePlan.equals(planDto.timePlan) : planDto.timePlan != null) return false;
        if (address != null ? !address.equals(planDto.address) : planDto.address != null) return false;
        if (price != null ? !price.equals(planDto.price) : planDto.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (entertainId != null ? entertainId.hashCode() : 0);
        result = 31 * result + (timePlan != null ? timePlan.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "plan")
    public Collection<ImageDto> getImages() {
        return images;
    }

    public void setImages(Collection<ImageDto> images) {
        this.images = images;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EntertainID", referencedColumnName = "ID", insertable = false, updatable = false)
    @JsonIgnore
    public EntertainDto getEntertain() {
        return entertain;
    }

    public void setEntertain(EntertainDto entertain) {
        this.entertain = entertain;
    }
}
