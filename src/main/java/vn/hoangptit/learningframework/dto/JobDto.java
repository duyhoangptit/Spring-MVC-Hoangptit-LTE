package vn.hoangptit.learningframework.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

/**
 * author Hoangptit
 * Date 9/26/2016
 */
@Entity
@Table(name = "job", schema = "adminlte", catalog = "")
public class JobDto {
    private Integer id;
    private Integer targetId;
    private String name;
    private String description;
    private Double sumJob;
    private Date timeJob;
    private TargetDto target;

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
    @Column(name = "TargetID")
    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
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

    @Basic
    @Column(name = "SumJob")
    public Double getSumJob() {
        return sumJob;
    }

    public void setSumJob(Double sumJob) {
        this.sumJob = sumJob;
    }

    @Basic
    @Column(name = "TimeJob")
    public Date getTimeJob() {
        return timeJob;
    }

    public void setTimeJob(Date timeJob) {
        this.timeJob = timeJob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobDto jobDto = (JobDto) o;

        if (id != null ? !id.equals(jobDto.id) : jobDto.id != null) return false;
        if (targetId != null ? !targetId.equals(jobDto.targetId) : jobDto.targetId != null) return false;
        if (name != null ? !name.equals(jobDto.name) : jobDto.name != null) return false;
        if (description != null ? !description.equals(jobDto.description) : jobDto.description != null) return false;
        if (sumJob != null ? !sumJob.equals(jobDto.sumJob) : jobDto.sumJob != null) return false;
        if (timeJob != null ? !timeJob.equals(jobDto.timeJob) : jobDto.timeJob != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (targetId != null ? targetId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (sumJob != null ? sumJob.hashCode() : 0);
        result = 31 * result + (timeJob != null ? timeJob.hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TargetID", referencedColumnName = "ID", insertable = false, updatable = false)
    @JsonIgnore
    public TargetDto getTarget() {
        return target;
    }

    public void setTarget(TargetDto target) {
        this.target = target;
    }
}
