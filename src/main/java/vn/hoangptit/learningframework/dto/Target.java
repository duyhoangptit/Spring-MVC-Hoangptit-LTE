package vn.hoangptit.learningframework.dto;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * @author Hoangptit
 *         12/09/2016
 */
@Entity
public class Target {
    private int id;
    private int objectiveId;
    private String title;
    private Date timeTarget;
    private String mission;
    private String comment;
    private double sumTarg;
    private Collection<Job> jobsById;
    private Objective objectiveByObjectiveId;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ObjectiveID")
    public int getObjectiveId() {
        return objectiveId;
    }

    public void setObjectiveId(int objectiveId) {
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
    public double getSumTarg() {
        return sumTarg;
    }

    public void setSumTarg(double sumTarg) {
        this.sumTarg = sumTarg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Target target = (Target) o;

        if (id != target.id) return false;
        if (objectiveId != target.objectiveId) return false;
        if (Double.compare(target.sumTarg, sumTarg) != 0) return false;
        if (title != null ? !title.equals(target.title) : target.title != null) return false;
        if (timeTarget != null ? !timeTarget.equals(target.timeTarget) : target.timeTarget != null) return false;
        if (mission != null ? !mission.equals(target.mission) : target.mission != null) return false;
        if (comment != null ? !comment.equals(target.comment) : target.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + objectiveId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (timeTarget != null ? timeTarget.hashCode() : 0);
        result = 31 * result + (mission != null ? mission.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        temp = Double.doubleToLongBits(sumTarg);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "targetByTargetId")
    public Collection<Job> getJobsById() {
        return jobsById;
    }

    public void setJobsById(Collection<Job> jobsById) {
        this.jobsById = jobsById;
    }

    @ManyToOne
    @JoinColumn(name = "ObjectiveID", referencedColumnName = "ID", nullable = false)
    public Objective getObjectiveByObjectiveId() {
        return objectiveByObjectiveId;
    }

    public void setObjectiveByObjectiveId(Objective objectiveByObjectiveId) {
        this.objectiveByObjectiveId = objectiveByObjectiveId;
    }
}
