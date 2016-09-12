package vn.hoangptit.learningframework.dto;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author Hoangptit
 *         12/09/2016
 */
@Entity
public class Tutorial {
    private int id;
    private int categoryId;
    private String name;
    private String note;
    private String description;
    private String author;
    private Date tutorialDate;
    private Category categoryByCategoryId;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CategoryID")
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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
    @Column(name = "Note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "TutorialDate")
    public Date getTutorialDate() {
        return tutorialDate;
    }

    public void setTutorialDate(Date tutorialDate) {
        this.tutorialDate = tutorialDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tutorial tutorial = (Tutorial) o;

        if (id != tutorial.id) return false;
        if (categoryId != tutorial.categoryId) return false;
        if (name != null ? !name.equals(tutorial.name) : tutorial.name != null) return false;
        if (note != null ? !note.equals(tutorial.note) : tutorial.note != null) return false;
        if (description != null ? !description.equals(tutorial.description) : tutorial.description != null)
            return false;
        if (author != null ? !author.equals(tutorial.author) : tutorial.author != null) return false;
        if (tutorialDate != null ? !tutorialDate.equals(tutorial.tutorialDate) : tutorial.tutorialDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + categoryId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (tutorialDate != null ? tutorialDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CategoryID", referencedColumnName = "ID", nullable = false)
    public Category getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(Category categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }
}
