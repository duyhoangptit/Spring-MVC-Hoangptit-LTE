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
@Table(name = "plan", schema = "adminlte")
public class PlanDto extends BaseDto{
    private Integer entertainId;
    private Date timePlan;
    private String address;
    private Double price;
    private Collection<ImageDto> images;
    private EntertainDto entertain;

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
