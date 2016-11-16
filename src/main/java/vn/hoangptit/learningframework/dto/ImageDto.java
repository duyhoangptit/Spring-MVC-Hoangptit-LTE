package vn.hoangptit.learningframework.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * author Hoangptit
 * Date 9/26/2016
 */
@Entity
@Table(name = "image", schema = "adminlte")
public class ImageDto extends BaseDto{
    private Integer planId;
    private String link;
    private String description;
    private PlanDto plan;

    @Basic
    @Column(name = "PlanID")
    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    @Basic
    @Column(name = "Link")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
    @JoinColumn(name = "PlanID", referencedColumnName = "ID", insertable = false, updatable = false)
    @JsonIgnore
    public PlanDto getPlan() {
        return plan;
    }

    public void setPlan(PlanDto plan) {
        this.plan = plan;
    }
}
