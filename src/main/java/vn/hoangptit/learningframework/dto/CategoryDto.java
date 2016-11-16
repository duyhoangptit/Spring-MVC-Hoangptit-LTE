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
public class CategoryDto extends BaseDto{
    private Integer learningId;
    private String name;
    private String description;
    private LearningDto learning;
    private Collection<TutorialDto> tutorials;

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
