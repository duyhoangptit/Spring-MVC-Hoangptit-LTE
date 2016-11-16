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
@Table(name = "target", schema = "adminlte")
public class TargetDto extends BaseDto{
    private Integer objectiveId;
    private String title;
    private Date timeTarget;
    private String mission;
    private String comment;
    private Double sumTarg;
    private Collection<JobDto> jobs;
    private ObjectiveDto objective;

    @Basic
    @Column(name = "ObjectiveID")
    public Integer getObjectiveId() {
        return objectiveId;
    }

    public void setObjectiveId(Integer objectiveId) {
        this.objectiveId = objectiveId;
    }

    @Basic
    @Column(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "TimeTarget")
    public Date getTimeTarget() {
        return timeTarget;
    }

    public void setTimeTarget(Date timeTarget) {
        this.timeTarget = timeTarget;
    }

    @Basic
    @Column(name = "Mission")
    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    @Basic
    @Column(name = "Comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "SumTarg")
    public Double getSumTarg() {
        return sumTarg;
    }

    public void setSumTarg(Double sumTarg) {
        this.sumTarg = sumTarg;
    }

    @OneToMany(mappedBy = "target")
    public Collection<JobDto> getJobs() {
        return jobs;
    }

    public void setJobs(Collection<JobDto> jobs) {
        this.jobs = jobs;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ObjectiveID", referencedColumnName = "ID",insertable = false, updatable = false)
    @JsonIgnore
    public ObjectiveDto getObjective() {
        return objective;
    }

    public void setObjective(ObjectiveDto objective) {
        this.objective = objective;
    }
}
