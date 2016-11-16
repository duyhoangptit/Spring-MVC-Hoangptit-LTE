package vn.hoangptit.learningframework.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

/**
 * author Hoangptit
 * Date 9/26/2016
 */
@Entity
@Table(name = "job", schema = "adminlte")
public class JobDto extends BaseDto{
    private Integer targetId;
    private String name;
    private String description;
    private Double sumJob;
    private Date timeJob;
    private TargetDto target;

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
