package vn.hoangptit.learningframework.dto;

import javax.persistence.*;

/**
 * @author Hoangptit
 *         12/09/2016
 */
@Entity
public class Image {
    private int id;
    private int planId;
    private String link;
    private String description;
    private Plan planByPlanId;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PlanID")
    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
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

        Image image = (Image) o;

        if (id != image.id) return false;
        if (planId != image.planId) return false;
        if (link != null ? !link.equals(image.link) : image.link != null) return false;
        if (description != null ? !description.equals(image.description) : image.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + planId;
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PlanID", referencedColumnName = "ID", nullable = false)
    public Plan getPlanByPlanId() {
        return planByPlanId;
    }

    public void setPlanByPlanId(Plan planByPlanId) {
        this.planByPlanId = planByPlanId;
    }
}
