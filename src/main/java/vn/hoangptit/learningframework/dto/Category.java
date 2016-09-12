package vn.hoangptit.learningframework.dto;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author Hoangptit
 *         12/09/2016
 */
@Entity
public class Category {
    private int id;
    private int learningId;
    private String name;
    private String description;
    private Learning learningByLearningId;
    private Collection<Tutorial> tutorialsById;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "LearningID")
    public int getLearningId() {
        return learningId;
    }

    public void setLearningId(int learningId) {
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

        Category category = (Category) o;

        if (id != category.id) return false;
        if (learningId != category.learningId) return false;
        if (name != null ? !name.equals(category.name) : category.name != null) return false;
        if (description != null ? !description.equals(category.description) : category.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + learningId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "LearningID", referencedColumnName = "ID", nullable = false)
    public Learning getLearningByLearningId() {
        return learningByLearningId;
    }

    public void setLearningByLearningId(Learning learningByLearningId) {
        this.learningByLearningId = learningByLearningId;
    }

    @OneToMany(mappedBy = "categoryByCategoryId")
    public Collection<Tutorial> getTutorialsById() {
        return tutorialsById;
    }

    public void setTutorialsById(Collection<Tutorial> tutorialsById) {
        this.tutorialsById = tutorialsById;
    }
}
