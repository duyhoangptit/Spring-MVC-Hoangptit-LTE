package vn.hoangptit.learningframework.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

/**
 * author Hoangptit
 * Date 9/26/2016
 */
@Entity
@Table(name = "category", schema = "adminlte")
public class CategoryDto {
    private Integer id;
    private Integer learningId;
    private String name;
    private String description;
    private LearningDto learning;
    private Collection<TutorialDto> tutorials;

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
    @Column(name = "LearningID")
    public Integer getLearningId() {
        return learningId;
    }

    public void setLearningId(Integer learningId) {
        this.learningId = learningId;
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

        CategoryDto that = (CategoryDto) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (learningId != null ? !learningId.equals(that.learningId) : that.learningId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (learningId != null ? learningId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LearningID", referencedColumnName = "ID", insertable = false, updatable = false)
    @JsonIgnore
    public LearningDto getLearning() {
        return learning;
    }

    public void setLearning(LearningDto learning) {
        this.learning = learning;
    }

    @OneToMany(mappedBy = "category")
    public Collection<TutorialDto> getTutorials() {
        return tutorials;
    }

    public void setTutorials(Collection<TutorialDto> tutorials) {
        this.tutorials = tutorials;
    }
}
