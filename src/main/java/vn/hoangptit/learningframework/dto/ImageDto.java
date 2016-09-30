package vn.hoangptit.learningframework.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * author Hoangptit
 * Date 9/26/2016
 */
@Entity
@Table(name = "image", schema = "adminlte", catalog = "")
public class ImageDto {
    private Integer id;
    private Integer planId;
    private String link;
    private String description;
    private PlanDto plan;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageDto imageDto = (ImageDto) o;

        if (id != null ? !id.equals(imageDto.id) : imageDto.id != null) return false;
        if (planId != null ? !planId.equals(imageDto.planId) : imageDto.planId != null) return false;
        if (link != null ? !link.equals(imageDto.link) : imageDto.link != null) return false;
        if (description != null ? !description.equals(imageDto.description) : imageDto.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (planId != null ? planId.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
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
