package vn.hoangptit.learningframework.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

/**
 * author Hoangptit
 * Date 9/26/2016
 */
@Entity
@Table(name = "tutorial", schema = "adminlte")
public class TutorialDto extends BaseDto{
    private Integer categoryId;
    private String name;
    private String note;
    private String description;
    private String author;
    private Date tutorialDate;
    private int view;
    private int like;
    private CategoryDto category;

    @Basic
    @Column(name = "CategoryID")
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
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

    @Basic
    @Column(name = "view")
    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    @Basic
    @Column(name = "like")
    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CategoryID", referencedColumnName = "ID", insertable = false, updatable = false)
    @JsonIgnore
    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }
}
