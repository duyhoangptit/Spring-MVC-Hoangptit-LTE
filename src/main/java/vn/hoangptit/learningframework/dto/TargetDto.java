package vn.hoangptit.learningframework.dto;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * @author hoangtd
 *         26/09/2016
 */
@Entity
@Table(name = "target", schema = "adminlte")
public class TargetDto {
    private Integer id;
    private Integer objectiveId;
    private String title;
    private Date timeTarget;
    private String mission;
    private String comment;
    private Double sumTarg;
    private Collection<JobDto> jobs;
    private ObjectiveDto objective;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TargetDto targetDto = (TargetDto) o;

        if (id != null ? !id.equals(targetDto.id) : targetDto.id != null) return false;
        if (objectiveId != null ? !objectiveId.equals(targetDto.objectiveId) : targetDto.objectiveId != null)
            return false;
        if (title != null ? !title.equals(targetDto.title) : targetDto.title != null) return false;
        if (timeTarget != null ? !timeTarget.equals(targetDto.timeTarget) : targetDto.timeTarget != null) return false;
        if (mission != null ? !mission.equals(targetDto.mission) : targetDto.mission != null) return false;
        if (comment != null ? !comment.equals(targetDto.comment) : targetDto.comment != null) return false;
        if (sumTarg != null ? !sumTarg.equals(targetDto.sumTarg) : targetDto.sumTarg != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (objectiveId != null ? objectiveId.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (timeTarget != null ? timeTarget.hashCode() : 0);
        result = 31 * result + (mission != null ? mission.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (sumTarg != null ? sumTarg.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "target")
    public Collection<JobDto> getJobs() {
        return jobs;
    }

    public void setJobs(Collection<JobDto> jobs) {
        this.jobs = jobs;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ObjectiveID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    public ObjectiveDto getObjective() {
        return objective;
    }

    public void setObjective(ObjectiveDto objective) {
        this.objective = objective;
    }
}
